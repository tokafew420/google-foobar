
public class Solution {
    public static String answer(int x, int y) {
        // x + y - 1;    nth triangular number (n)
        // (n * (n + 1)) / 2;   nth triangular number value (t)
        // return (t - (n - x))

        return String.valueOf(((x + y - 1L) * (x + y)) / 2 - y + 1);
    }
}
