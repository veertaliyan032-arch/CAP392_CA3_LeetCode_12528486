// LeetCode 9 - Palindrome Number (Easy)
// (The assignment table calls it "Valid Palindrome"; LeetCode #9 is "Palindrome Number".)
// Approach: reverse the second half of the number and compare with the first half.
// Time: O(log x)  Space: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121) + " (expected true)");
        System.out.println(s.isPalindrome(-121) + " (expected false)");
        System.out.println(s.isPalindrome(10) + " (expected false)");
        System.out.println(s.isPalindrome(0) + " (expected true)");
        System.out.println(s.isPalindrome(1221) + " (expected true)");
    }
}
