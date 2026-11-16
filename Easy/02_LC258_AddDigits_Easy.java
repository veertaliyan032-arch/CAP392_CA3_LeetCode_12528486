// LeetCode 258 - Add Digits (Easy)
// Approach: repeatedly sum digits until a single digit remains.
// Time: O(log n) per pass  Space: O(1)
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addDigits(38) + " (expected 2)");
        System.out.println(s.addDigits(0) + " (expected 0)");
        System.out.println(s.addDigits(9) + " (expected 9)");
        System.out.println(s.addDigits(2147483647) + " (expected 1)");
    }
}
