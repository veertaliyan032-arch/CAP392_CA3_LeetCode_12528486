// LeetCode 41 - First Missing Positive (Hard)
// Approach: cyclic sort - place each value v (1..n) at index v-1, then find first mismatch.
// Time: O(n)  Space: O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{1, 2, 0}) + " (expected 3)");
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}) + " (expected 2)");
        System.out.println(s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}) + " (expected 1)");
        System.out.println(s.firstMissingPositive(new int[]{1}) + " (expected 2)");
        System.out.println(s.firstMissingPositive(new int[]{1, 1}) + " (expected 2)");
    }
}
