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
        answer = Solution.answer("4");
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 2 == answer ? 0 : 1, time);

        // Test case 2
        // From example 2
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer("15");
        time = System.currentTimeMillis() - start;

        printResult(caseNum, 5 == answer ? 0 : 1, time);

        // Test case 3
        // Run first 20 and verify
        int[] inputs =  new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] answers = new int[] { 0, 1, 2, 2, 3, 3, 4, 3, 4,  4,  5,  4,  5,  5,  5,  4,  5,  5,  6,  5 };
        caseNum = 3;
        for(int i = 0; i < 20; i++) {
            start = System.currentTimeMillis();
            answer = Solution.answer(String.valueOf(inputs[i]));
            printResult(caseNum, answers[i] == answer ? 0 : 1, time);
        }

        // Test case 4
        // Really large numbers
        caseNum = 4;
        for (int i = 0; i < 10; i++) {
            int digits = ThreadLocalRandom.current().nextInt(200, 309);
            String num = "";
            for(int j = 0; j < digits; j++) {
                num += String.valueOf(ThreadLocalRandom.current().nextInt(0, 9));
            }
            start = System.currentTimeMillis();
            answer = Solution.answer(num);
            time = System.currentTimeMillis() - start;

            System.out.format("Digits: %s\nAnswer: %d%n", num, answer);
            printResult(caseNum, -1, time);
        }
    }

    public static void printResult(int caseNum, int passed, long time) {
        String result = passed == -1 ? "Not Verified" : passed == 0 ? "Passed" : "Failed";
        System.out.format("Test case %d: %s %dms%n", caseNum, result, time);
    }
}
