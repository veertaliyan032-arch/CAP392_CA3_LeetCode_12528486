class Solution {
    public int fib(int n) {
        int a = 0; // F(0)
        int b = 1; // F(1)
        
        for (int i = 1; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        
        return a;
    }
}
