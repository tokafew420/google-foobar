import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {
    public static void main(String[] args) {
        String answer;
        long start;
        long time;
        int caseNum;

        // Test case 1
        caseNum = 1;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 2, 0, 2, 2, 0 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "8".equals(answer) ? 0 : 1, time);

        // Test case 2
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { -2, -3, 4, -5 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "60".equals(answer) ? 0 : 1, time);

        // Test case 3
        // From the problem description
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 2, -3, 1, 0, -5 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "30".equals(answer) ? 0 : 1, time);

        // Boundry cases

        // Test case 4
        // A single zero output panel
        caseNum = 4;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 0 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "0".equals(answer) ? 0 : 1, time);

        // Test case 5
        // A single good panel
        caseNum = 5;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 1 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "1".equals(answer) ? 0 : 1, time);

        // Test case 6
        // A single malfunctioning panel
        caseNum = 6;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { -1 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "-1".equals(answer) ? 0 : 1, time);

        // Test case 7
        // A zero output with multiple panels
        caseNum = 7;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 0, 0, -5, 0});
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "0".equals(answer) ? 0 : 1, time);

        // Test case 8
        // Even number of malfunctioning panels
        caseNum = 8;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 1, -1, 2, 0, -2, 3, -3, 4, -4 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "576".equals(answer) ? 0 : 1, time);

        // Test case 9
        // Odd number of malfunctioning panels
        caseNum = 9;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 1, -1, 2, -2, 3, 0, -3, 0, 4 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "144".equals(answer) ? 0 : 1, time);

        // Test case 10
        // Really big numbers
        caseNum = 10;
        start = System.currentTimeMillis();
        answer = Solution.answer(new int[] { 1000, -1000, 0, 0, 999, -999, 998, -998, 997 });
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "993016983006000000".equals(answer) ? 0 : 1, time);

        // Test case 11
        // Max elements
        caseNum = 11;
        int[] panels = new int[50];
        for (int i = 0; i < 50; i++) {
            panels[i] = ThreadLocalRandom.current().nextInt(-1000, 1001);;
        }
        start = System.currentTimeMillis();
        answer = Solution.answer(panels);
        time = System.currentTimeMillis() - start;

        System.out.format("Input = %s%n", Arrays.toString(panels));
        System.out.format("Answer = %s%n", answer);
        printResult(caseNum, -1, time);
    }

    public static void printResult(int caseNum, int passed, long time) {
        String result = passed == -1 ? "Not Verified" : passed == 0 ? "Passed" : "Failed";
        System.out.format("Test case %d: %s %dms%n", caseNum, result, time);
    }
}
