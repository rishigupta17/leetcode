package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Leet3LongestSub {

    public static void main(String[] args) {
        Leet3LongestSub solution = new Leet3LongestSub();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int curr = 0,first = 0;

        while(curr<s.length()) {
            if(!set.add(s.charAt(curr))) {
                while(s.charAt(first) != s.charAt(curr)) {
                    set.remove(s.charAt(first));
                    first++;
                }
                first++;
            }

            maxLength = Math.max(set.size(), maxLength);
            curr++;
        }

        return maxLength;
    }
}