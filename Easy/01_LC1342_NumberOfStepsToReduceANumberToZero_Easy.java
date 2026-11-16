// LeetCode 1342 - Number of Steps to Reduce a Number to Zero (Easy)
// Approach: simulate. Even -> divide by 2, odd -> subtract 1.
// Time: O(log n)  Space: O(1)
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfSteps(14) + " (expected 6)");
        System.out.println(s.numberOfSteps(8) + " (expected 4)");
        System.out.println(s.numberOfSteps(123) + " (expected 12)");
        System.out.println(s.numberOfSteps(0) + " (expected 0)");
    }
}
