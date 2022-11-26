import org.junit.Test;

public class lc28FindtheIndexoftheFirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        int leftInHaystack = 0, rightInHaystack = 0;
        int indexCheckedInNeedle = 0;
        while (leftInHaystack < haystack.length()) {
            while (rightInHaystack < haystack.length() && haystack.charAt(rightInHaystack++) == needle.charAt(indexCheckedInNeedle++)) {
                if (indexCheckedInNeedle == needle.length()) {
                    return rightInHaystack - needle.length();
                }
            }
            rightInHaystack = ++leftInHaystack;
            indexCheckedInNeedle = 0;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
