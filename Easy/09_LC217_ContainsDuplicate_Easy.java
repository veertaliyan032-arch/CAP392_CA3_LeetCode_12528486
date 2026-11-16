// LeetCode 217 - Contains Duplicate (Easy)
// Approach: HashSet; if add() fails, a duplicate exists.
// Time: O(n)  Space: O(n)
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}) + " (expected true)");
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 4}) + " (expected false)");
        System.out.println(s.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) + " (expected true)");
        System.out.println(s.containsDuplicate(new int[]{7}) + " (expected false)");
    }
}
