
public class Runner {
    public static void main(String[] args) throws java.lang.Exception {
        String answer;
        long start;
        long time;
        int caseNum;

        // Test case 1
        caseNum = 1;
        start = System.currentTimeMillis();
        answer = Solution.answer("code");
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "100100101010100110100010".equals(answer) ? 0 : 1, time);

        // Test case 2
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer("Braille");
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "000001110000111010100000010100111000111000100010".equals(answer) ? 0 : 1, time);

        // Test case 3
        caseNum = 3;
        start = System.currentTimeMillis();
        answer = Solution.answer("The quick brown fox jumped over the lazy dog");
        time = System.currentTimeMillis() - start;

        printResult(caseNum,
                "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100100010100110000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110"
                        .equals(answer) ? 0 : 1,
                time);
    }

    public static void printResult(int caseNum, int passed, long time) {
        String result = passed == -1 ? "Not Verified" : passed == 0 ? "Passed" : "Failed";
        System.out.format("Test case %d: %s %dms%n", caseNum, result, time);
    }
}
