// LeetCode 7 - Reverse Integer (Easy in this assignment's table)
// Approach: pop digits with % 10 and push to result; check overflow before multiplying.
// Time: O(log x)  Space: O(1)
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123) + " (expected 321)");
        System.out.println(s.reverse(-123) + " (expected -321)");
        System.out.println(s.reverse(120) + " (expected 21)");
        System.out.println(s.reverse(1534236469) + " (expected 0)");
        System.out.println(s.reverse(0) + " (expected 0)");
    }
}
