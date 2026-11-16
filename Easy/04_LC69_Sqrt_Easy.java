// LeetCode 69 - Sqrt(x) (Easy)
// Approach: binary search for the largest r with r*r <= x (long to avoid overflow).
// Time: O(log x)  Space: O(1)
class Solution {
    public int mySqrt(int x) {
        long lo = 0, hi = x, ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= x) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(4) + " (expected 2)");
        System.out.println(s.mySqrt(8) + " (expected 2)");
        System.out.println(s.mySqrt(0) + " (expected 0)");
        System.out.println(s.mySqrt(2147395599) + " (expected 46339)");
    }
}
