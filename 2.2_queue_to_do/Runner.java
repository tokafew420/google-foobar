import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {
    public static void main(String[] args) {
        int answer;
        long start;
        long time;
        int caseNum;

        // Test case 1
        // From example 1
        caseNum = 1;
        start = System.currentTimeMillis();
        answer = Solution.answer(0, 3);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 2 == answer ? 0 : 1, time);

        // Test case 2
        // From example 2
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer(17, 4);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 14 == answer ? 0 : 1, time);

        // Test case 3
        // Boundary case: length of 1
        caseNum = 3;
        start = System.currentTimeMillis();
        answer = Solution.answer(12, 1);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 12 == answer ? 0 : 1, time);

        // Test case 4
        // Boundary case: Running out of prisoners
        caseNum = 4;
        start = System.currentTimeMillis();
        answer = Solution.answer(2000000000, 5);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 2000000000 == answer ? 0 : 1, time);

        // Test case 5
        // Process all prisoners (take sqrt of 2000000000)
        caseNum = 5;
        start = System.currentTimeMillis();
        answer = Solution.answer(0, 44722);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, -1, time);

        // Test case 6
        // Run 50 trails with random numbers.
        caseNum = 6;
        start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            int inputStart = ThreadLocalRandom.current().nextInt(0, 2000000);
            int inputLength = ThreadLocalRandom.current().nextInt(1, 2000000);
            answer = Solution.answer(inputStart, inputLength);

            System.out.format("Start = %d, Length = %d, answer = %d%n", inputStart, inputLength, answer);
        }
        time = System.currentTimeMillis() - start;
        printResult(caseNum, -1, time);
    }

    public static void printResult(int caseNum, int passed, long time) {
        String result = passed == -1 ? "Not Verified" : passed == 0 ? "Passed" : "Failed";
        System.out.format("Test case %d: %s %dms%n", caseNum, result, time);
    }
}
