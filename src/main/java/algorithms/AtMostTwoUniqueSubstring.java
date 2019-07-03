package algorithms;

import java.util.Arrays;

/*
 * Task**: Find the longest sequence with at most 2 different characters.
 * Output**: Print the length of the sequence.
 */
class AtMostTwoUniqueSubstring {
    private static final int TOTAL_UNIQUE_CHARS = 256;
    private static final char FIRST_CHAR = '!';
    private static final int[] CACHE = new int[TOTAL_UNIQUE_CHARS];

    private static boolean lessOccurrencesThan() {
        int sum = 0;
        for (int value : CACHE) {
            sum += value > 0 ? 1 : 0;
            if (sum > 2) {
                return true;
            }
        }
        return false;
    }

    static int longest2UniqueSequenceLength(final String input) {
        return longest2UniqueSequence(input).length();
    }

    private static String longest2UniqueSequence(final String input) {
        if (input == null || "".equals(input)) {
            return "";
        }
        int start = 0;
        int end = 0;
        int max_length = 1;
        int max_start = 0;

        Arrays.fill(CACHE, 0);
        CACHE[input.charAt(0) - FIRST_CHAR]++;

        for (int i = 1; i < input.length(); i++) {
            CACHE[input.charAt(i) - FIRST_CHAR]++;
            end++;

            while (lessOccurrencesThan()) {
                CACHE[input.charAt(start) - FIRST_CHAR]--;
                start++;
            }
            if (end - start + 1 > max_length) {
                max_length = end - start + 1;
                max_start = start;
            }
        }
        return input.substring(max_start, max_start + max_length);
    }

    public static void main(String... args) {
        String input = "alwayshopeforthebest";
        System.out.println(longest2UniqueSequenceLength(input));
    }
}
