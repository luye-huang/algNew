import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class lc17LetterCombinationsofaPhoneNumber {
    char[][] dict = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    List<String> ret = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ret;
        }
        char[][] choice = new char[digits.length()][digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            choice[i] = dict[digits.charAt(i) - 48];
        }
        backtrack(0, new StringBuilder(), choice);
        return ret;
    }

    //用stringbuilder 快于 str+= ，替换后由12ms提高到0ms
    private void backtrack(int layer, StringBuilder sb, char[][] choices) {
        if (layer == choices.length) {
            ret.add(sb.toString());
            return;
        }
        for (char c : choices[layer]) {
            sb.append(c);
            backtrack(layer + 1, sb, choices);
            sb.setLength(sb.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));

    }
}
