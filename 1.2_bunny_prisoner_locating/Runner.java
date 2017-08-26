
public class Runner {
    public static void main(String[] args) {
        String answer;
        long start;
        long time;
        int caseNum;

        // Test case 1
        caseNum = 1;
        start = System.currentTimeMillis();
        answer = Solution.answer(3, 2);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "9".equals(answer) ? 0 : 1, time);

        // Test case 2
        caseNum = 2;
        start = System.currentTimeMillis();
        answer = Solution.answer(5, 10);
        time = System.currentTimeMillis() - start;

        printResult(caseNum, "96".equals(answer) ? 0 : 1, time);

        // Test case 3
        // Iterate to 1000 and test answer
        int id = 1;
        int n = 1;
        int max = 1000;
        int x, y;
        boolean failed = false;

        caseNum = 3;
        start = System.currentTimeMillis();
        while(n <= max && !failed) {
            x = 1;
            y = n++;

            while(y > 0 && !failed) {
                answer = Solution.answer(x++, y--);
                if(!String.valueOf(id++).equals(answer)) {
                    failed = true;
                    break;
                }
            }
        }
        time = System.currentTimeMillis() - start;

        printResult(caseNum, failed ? 1 : 0, time);
    }

    public static void printResult(int caseNum, int passed, long time) {
        String result = passed == -1 ? "Not Verified" : passed == 0 ? "Passed" : "Failed";
        System.out.format("Test case %d: %s %dms%n", caseNum, result, time);
    }
}
