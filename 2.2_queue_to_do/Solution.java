
public class Solution {

    public static int answer(int start, int length) {
        int result = 0;
        for(int i = 0; i < length ; i++) {
            // Find the id of the first prisoner in
            // for the current iteration
            int lineStart = start + (length * i);

            // Going backwards so we only calculate stopping point once.
            for(int j = length - i; j > 0; j--, lineStart++) {
                // Ensure we stop if we have no more prisoners.
                if(lineStart > 2000000000) return result;
                result ^= lineStart;
            }
        }

        return result;
    }
}
