package algorithms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class AtMostTwoUniqueSubstringTest {
    @DataProvider
    public Object[][] alphabetical() {
        return new Object[][]{
                {null, 0},
                {"", 0},
                {"a", 1},
                {"aa", 2},
                {"aaa", 3},
                {"aab", 3},
                {"aabb", 4},
                {"aabbe", 4}, // aabb <- longest
                {"aaebb", 3}, // aae, ebb
                {"aabbccbb", 6}, //bbccbb <- longest
                {"aaabbbaacceeegggeegrffff", 9} // - eeegggeeg  <- longest
        };
    }

    @Test(dataProvider = "alphabetical")
    public void alphabetical(String input, int length) {
        check(input, length);
    }

    @DataProvider
    public Object[][] numerical() {
        return new Object[][]{
                {"2", 1},
                {"22", 2},
                {"222", 3},
                {"223", 3},
                {"2233", 4},
                {"22334", 4}, // 2233 <- longest
                {"22433", 3}, // 224, 433
                {"22334433", 6}, //334433 <- longest
                {"222333224455566655687777", 9} // - 555666556  <- longest
        };
    }

    @Test(dataProvider = "numerical")
    public void numerical(String input, int length) {
        check(input, length);
    }

    @DataProvider
    public Object[][] special() {
        return new Object[][]{
                {"@", 1},
                {"@@", 2},
                {"@@@", 3},
                {"@@#", 3},
                {"@@##", 4},
                {"@@##$", 4}, // @@## <- longest
                {"@@$##", 3}, // @@$, $##
                {"@@##$$##", 6}, //##$$## <- longest
                {"@@@###@@$$%%%^^^%%^*&&&&", 9} // - %%%^^^%%^  <- longest
        };
    }

    @Test(dataProvider = "special")
    public void special(String input, int length) {
        check(input, length);
    }

    @DataProvider
    public Object[][] mix() {
        return new Object[][]{
                {null, 0},
                {"", 0},
                {"a", 1},
                {"aa", 2},
                {"aaa", 3},
                {"aa^", 3},
                {"aa^^", 4},
                {"aa^^8", 4}, // aa^^ <- longest
                {"aa8^^", 3}, // aa8, 8^^
                {"aa^^cc^^", 6}, //^^cc^^ <- longest
                {"aaa^^^aacc888ggg88g*&&&&", 9} // - 888ggg88g  <- longest
        };
    }

    @Test(dataProvider = "mix")
    public void mix(String input, int length) {
        check(input, length);
    }

    private void check(String input, int length) {
        int actual = AtMostTwoUniqueSubstring.longest2UniqueSequenceLength(input);
        assertEquals(actual, length);
    }

    @Test(enabled = false)
    public void run_with_care() {
        int maximumHeapSize = 1024 * 1024 * 1024 - 1;
        final String alphabet = "~!@#$%^&*()_+0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(maximumHeapSize / 2, Integer.MAX_VALUE); i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        int actual = AtMostTwoUniqueSubstring.longest2UniqueSequenceLength(sb.toString());
        assertTrue(actual > 0);
    }
}
