
public class Solution {
    private static String[] mapping = { "100000", // a
            "110000", // b
            "100100", // c
            "100110", // d
            "100010", // e
            "110100", // f
            "110110", // g
            "110010", // h
            "010100", // i
            "010110", // j
            "101000", // k
            "111000", // l
            "101100", // m
            "101110", // n
            "101010", // o
            "111100", // p
            "111110", // q
            "111010", // r
            "011100", // s
            "011110", // t
            "101001", // u
            "111001", // v
            "010111", // w
            "101101", // x
            "101111", // y
            "101011" // z
    };

    public static String answer(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, len = plaintext.length(); i < len; i++) {
            int code = (int) plaintext.charAt(i);

            if (code == 32) {
                // Space
                result.append("000000");
            } else {
                if (code >= 65 && code <= 90) {
                    // Uppercase
                    result.append("000001");
                    code += 32; // Make it lower
                }
                // Lowercase
                result.append(mapping[code - 97]);
            }
        }
        return result.toString();
    }
}
