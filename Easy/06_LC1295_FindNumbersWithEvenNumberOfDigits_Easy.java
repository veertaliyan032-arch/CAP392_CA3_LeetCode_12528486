// LeetCode 1295 - Find Numbers with Even Number of Digits (Easy)
// Approach: count digits of each number by repeated division.
// Time: O(n * d)  Space: O(1)
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            int digits = 0;
            while (n > 0) {
                digits++;
                n /= 10;
            }
            if (digits % 2 == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumbers(new int[]{12, 345, 2, 6, 7896}) + " (expected 2)");
        System.out.println(s.findNumbers(new int[]{555, 901, 482, 1771}) + " (expected 1)");
        System.out.println(s.findNumbers(new int[]{100000}) + " (expected 1)");
    }
}
