package algorithms;

import java.util.Arrays;

/*
 * Task**: Find the longest sequence with at most 2 different characters.
 * Output**: Print the length of the sequence.
 */
public class KUniqueSubstring {
    private static final int TOTAL_UNIQUE_CHARS = 256;
    private static final char FIRST_CHAR = '!';
    private static final int[] map = new int[TOTAL_UNIQUE_CHARS];

    private static boolean lessOccurrencesThan(int[] map, int k) {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            sum += map[i] > 0 ? 1 : 0;
            if (sum > k) {
                return true;
            }
        }
        return false;
    }

    public static int longest2UniqueSequenceLength(final String input) {
        return longestKUniqueSequence(input, 2).length();
    }

    private static String longestKUniqueSequence(final String input, int k) {
        if (input == null || "".equals(input)) {
            return "";
        }
        int start = 0;
        int end = 0;
        int max_length = 1;
        int max_start = 0;

        Arrays.fill(map, 0);
        map[input.charAt(0) - FIRST_CHAR]++;

        for (int i = 1; i < input.length(); i++) {
            map[input.charAt(i) - FIRST_CHAR]++;
            end++;

            while (lessOccurrencesThan(map, k)) {
                map[input.charAt(start) - FIRST_CHAR]--;
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
        String input = args[0]; // "aabacbebebe";
        System.out.println(longest2UniqueSequenceLength(input));
    }
}
