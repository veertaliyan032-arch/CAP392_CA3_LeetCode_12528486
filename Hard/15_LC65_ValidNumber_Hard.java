// LeetCode 65 - Valid Number (Hard)
// Approach: single pass with flags (seen digit, seen dot, seen exponent).
// Sign only allowed at start or right after e/E; dot not allowed after e or after another dot;
// e/E needs a digit before it and a digit after it.
// Time: O(n)  Space: O(1)
class Solution {
    public boolean isNumber(String s) {
        boolean digit = false, dot = false, exp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !digit) return false;
                exp = true;
                digit = false; // need digits after the exponent
            } else {
                return false;
            }
        }
        return digit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] valid = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] invalid = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", ".", "e", "+", "1+", ""};
        for (String v : valid) System.out.println(v + " -> " + s.isNumber(v) + " (expected true)");
        for (String v : invalid) System.out.println("\"" + v + "\" -> " + s.isNumber(v) + " (expected false)");
    }
}
