// LeetCode 2114 - Maximum Number of Words Found in Sentences (Easy)
// Approach: words = (number of spaces + 1); track maximum.
// Time: O(total characters)  Space: O(1)
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int words = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') words++;
            }
            max = Math.max(max, words);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}) + " (expected 6)");
        System.out.println(s.mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}) + " (expected 3)");
        System.out.println(s.mostWordsFound(new String[]{"a"}) + " (expected 1)");
    }
}
