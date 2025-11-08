package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Leet76MinWindowSubstring {

    public static void main(String[] args) {
        Leet76MinWindowSubstring solution = new Leet76MinWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(solution.minWindow("a","a"));
        System.out.println(solution.minWindow("a","aa"));
        System.out.println(solution.minWindow("a","b"));
        System.out.println(solution.minWindow("DOBECODEBANCDF","ABC"));

    }

    public String minWindow(String s, String t) {

        int ls = s.length();
        int lt = t.length();
        //length check
        if (ls < lt) return "";

        Map<Character,Integer> freqT = new HashMap<>();
        Map<Character,Integer> freqWindow = new HashMap<>();
        int resultStart = 0;
        int resultEnd = Integer.MAX_VALUE;

        //Get char freq for t
        for(int i=0; i<lt;i++) {
            freqT.put(t.charAt(i),freqT.getOrDefault(t.charAt(i),0)+1);
        }

        // loop to slide window
        //      check window valid
        //      try to reduce window while valid
        //      update resultWindow
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<ls; windowEnd++) {

            freqWindow.put(s.charAt(windowEnd), freqWindow.getOrDefault(s.charAt(windowEnd),0)+1);

            while(isValidWindow(freqT,freqWindow)) {
                if(windowEnd-windowStart < resultEnd-resultStart){
                    resultStart = windowStart;
                    resultEnd = windowEnd;
                }
                freqWindow.put(s.charAt(windowStart), freqWindow.get(s.charAt(windowStart))-1);
                windowStart++;
            }
        }

        if(resultEnd == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(resultStart, resultEnd + 1);
        }
    }

    boolean isValidWindow(Map<Character,Integer> mt, Map<Character,Integer> mWindow) {
        for(Character ch: mt.keySet()) {
            if(mWindow.getOrDefault(ch,-1) < mt.getOrDefault(ch,-1)) {
                return false;
            }
        }
        return true;
    }
}
