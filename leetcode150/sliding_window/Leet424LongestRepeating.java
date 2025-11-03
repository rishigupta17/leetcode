package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet424LongestRepeating {

    public static void main(String[] args) {
        Leet424LongestRepeating solution = new Leet424LongestRepeating();
        System.out.println(solution.characterReplacement("ABAB",2));
        System.out.println(solution.characterReplacement("AABABBA",1));
        System.out.println(solution.characterReplacement("BBABB",1));
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int totalMax = 0;
        int currentMaxCharCount = 0;

        for(windowEnd = 0; windowEnd<s.length();windowEnd++) {

            //Update window char count
            charCount.put(s.charAt(windowEnd),
                    charCount.getOrDefault(s.charAt(windowEnd),0)+1);

            // update current max char count from the map
            // Full map scan not required, as we have previous max, so this can be the only new max possibility
            currentMaxCharCount = Math.max(currentMaxCharCount, charCount.get(s.charAt(windowEnd)));

            // shrink left - we don't need to keep shrinking as even if we do the window size will be less
            // and we already have a bigger window for answer. So we slide the same window by 1
            // if new char or right is not the same as start.
            //      and if start was not the max char then we violate the rule due to bigger window
            //      and if start was the max char, then we violate the rule due to reduction of currentmax
            if(windowEnd-windowStart+1 - currentMaxCharCount > k) {
                charCount.put(s.charAt(windowStart),
                        charCount.getOrDefault(s.charAt(windowStart),0)-1);
                windowStart++;
            }

            //update totalMax with window size
            totalMax = Math.max(totalMax,windowEnd-windowStart+1);

        }

        return totalMax;
    }
}