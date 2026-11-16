// LeetCode 2349 - Design a Number Container System (Medium)
// Approach: index -> number map, plus number -> TreeSet of indices (smallest = first()).
// Time: O(log n) per operation  Space: O(n)
import java.util.*;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumber = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public NumberContainers() {}

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int old = indexToNumber.get(index);
            if (old == number) return;
            TreeSet<Integer> set = numberToIndices.get(old);
            set.remove(index);
            if (set.isEmpty()) numberToIndices.remove(old);
        }
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> set = numberToIndices.get(number);
        return (set == null || set.isEmpty()) ? -1 : set.first();
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10) + " (expected -1)");
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        System.out.println(nc.find(10) + " (expected 1)");
        nc.change(1, 20);
        System.out.println(nc.find(10) + " (expected 2)");
        System.out.println(nc.find(20) + " (expected 1)");
    }
}
