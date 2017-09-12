
public class Solution {
    public static int answer(String n) {
        int len = n.length();
        byte[] num = new byte[len];
        String bin = "";
        int ops = 0;

        // Convert string to byte array.
        for (int i = 0; i < len; num[i] = Byte.valueOf(n.substring(i++, i)));

        // Convert number array into binary string.
        while (greaterThanZero(num)) {
            if (divideByTwo(num)) {
                bin = "1" + bin;
            } else {
                bin = "0" + bin;
            }
        }

        boolean addedOne = false;   // Our carry flag

        // Reduce binary to 1
        for (int i = bin.length() - 1; i > 0; i--) {
            boolean currentBit = bin.charAt(i) == '1';
            boolean nextBit = bin.charAt(i - 1) == '1';

            if (addedOne) {
                // If we previously added one then flip the bit
                currentBit = !currentBit;
            }
            if (currentBit) {
                // Current Bit is 1 we need to decide whether to add
                // or subtract
                if (!nextBit || i == 1) {
                    // If next bit is 0 or if we are
                    // at the second to last bit (left most) then
                    // minus one and divide by 2

                    addedOne = false; // Reset flag
                    // -> (-1) -> (/2)
                } else {
                    // Otherwise add 1 then divide by 2
                    addedOne = true; // Carry 1

                    // -> (+1) -> (/2)
                }
                ops += 2;
            } else {
                // Current bit is 0 so just divide by 2
                // -> (/2)
                ops++;
            }
        }

        // Final check in case we still have a carry
        if (addedOne) {
            // -> (/2)
            ops++;
        }

        return ops;
    }

    /**
     * Divide a byte array representing a number by 2.
     * Returns true if there is a remainder.
     */
    static boolean divideByTwo(byte[] num) {
        boolean hasRemainder = false;

        for (int i = 0, ii = num.length; i < ii; i++) {
            hasRemainder = (num[i] % 2) == 1;
            num[i] = (byte) (num[i] / 2);

            if (i < ii - 1 && hasRemainder) {
                num[i + 1] += 10;
            }
        }

        return hasRemainder;
    }

    /**
     * Determine if a byte array representing a number is greater
     * than zero.
     */
    static boolean greaterThanZero(byte[] num) {
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] > 0)
                return true;
        }
        return false;
    }
}
