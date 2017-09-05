import java.math.BigInteger;

public class Solution {
    public static String answer(int[] xs) {
        BigInteger totalPower = BigInteger.valueOf(1); // Start out with 1
        boolean hasPower = false; // Indicates a non-zero result
        boolean hasStabilizer = false; // Indicates there's an addition malfunctioning panel to use as a stabilizer
        int highMalfunction = 0; // Malfunctioning panel with less drain
        int lowMalfunction = 0; // Malfunctioning panel with more drain
        int len = xs.length;

        // In case the array has only one panel just return its value.
        if (len == 1) {
            return String.valueOf(xs[0]);
        }

        for (int i = 0; i < len; i++) {
            int power = xs[i];

            if (power < 0) {
                if (power == -1) {
                    // Don't multiply if there's no gain.
                    if (hasStabilizer) {
                        // Double stabilizer means there's power (1)
                        hasPower = true;
                    }
                    // Only need one to flip the sign
                    hasStabilizer = true;
                } else {
                    if (lowMalfunction == 0) {
                        // First pass through, Save for later
                        lowMalfunction = power;
                    } else if (highMalfunction == 0) {
                        // Save for later (and re-order)
                        if (power > lowMalfunction) {
                            highMalfunction = power;
                        } else {
                            highMalfunction = lowMalfunction;
                            lowMalfunction = power;
                        }
                    } else {
                        // Now we have the third malfunctioning panel
                        // Combine 2 higher malfunctioning panels
                        if (power > highMalfunction) {
                            totalPower = totalPower.multiply(BigInteger.valueOf(lowMalfunction * highMalfunction));
                            lowMalfunction = power;
                        } else {
                            totalPower = totalPower.multiply(BigInteger.valueOf(lowMalfunction * power));
                            lowMalfunction = highMalfunction;
                        }
                        highMalfunction = 0;
                        hasPower = true;
                    }
                }
            } else if (power > 0) {
                // Don't multiply if there's no gain
                if (power > 1) {
                    // Combine good panels (with gain only)
                    totalPower = totalPower.multiply(BigInteger.valueOf(power));
                }
                hasPower = true;
            }
        }

        // Even number of malfunctioning panels. Stabilizer them!!
        if (lowMalfunction != 0 && highMalfunction != 0) {
            totalPower = totalPower.multiply(BigInteger.valueOf(lowMalfunction * highMalfunction));
            hasPower = true;
        } else if (lowMalfunction != 0 && hasStabilizer) {
            totalPower = totalPower.multiply(BigInteger.valueOf(lowMalfunction * -1));
            hasPower = true;
        }

        return hasPower ? totalPower.toString() : "0";
    }
}
