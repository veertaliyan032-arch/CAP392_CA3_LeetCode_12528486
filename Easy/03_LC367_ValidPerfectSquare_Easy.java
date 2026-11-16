// LeetCode 367 - Valid Perfect Square (Easy)
// Approach: binary search for an integer whose square equals num (use long to avoid overflow).
// Time: O(log n)  Space: O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == num) return true;
            if (sq < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(16) + " (expected true)");
        System.out.println(s.isPerfectSquare(14) + " (expected false)");
        System.out.println(s.isPerfectSquare(1) + " (expected true)");
        System.out.println(s.isPerfectSquare(2147483647) + " (expected false)");
    }
}
