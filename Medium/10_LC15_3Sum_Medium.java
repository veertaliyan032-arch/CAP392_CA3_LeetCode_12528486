// LeetCode 15 - 3Sum (Medium)
// Approach: sort, fix one number, two pointers for the rest; skip duplicates.
// Time: O(n^2)  Space: O(1) extra (ignoring output)
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}) + " (expected [[-1,-1,2],[-1,0,1]])");
        System.out.println(s.threeSum(new int[]{0, 1, 1}) + " (expected [])");
        System.out.println(s.threeSum(new int[]{0, 0, 0}) + " (expected [[0,0,0]])");
        System.out.println(s.threeSum(new int[]{0, 0, 0, 0}) + " (expected [[0,0,0]])");
    }
}
