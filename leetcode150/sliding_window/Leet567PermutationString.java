package sliding_window;

public class Leet567PermutationString {

    public static void main(String[] args) {
        Leet567PermutationString solution = new Leet567PermutationString();
        System.out.println(solution.checkInclusion("ab","eidbaooo"));
        System.out.println(solution.checkInclusion("ab","eidboaoo"));
        System.out.println(solution.checkInclusion("a","eidboaoo"));
        System.out.println(solution.checkInclusion("c","eidboaoo"));
        System.out.println(solution.checkInclusion("a","ab"));

    }

    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) {
            return false;
        }

        int freqS1[] = new int[26];
        int freqWindow[] = new int[26];

        //Capture initial window frequency and s1 freq
        for(int i=0;i<s1.length();i++) {
            freqS1[s1.charAt(i)-'a']++;
            freqWindow[s2.charAt(i)-'a']++;
        }

        //Check for match and keep sliding window
        for(int i=0;i<s2.length()-s1.length();i++) {
            if(isFrequencyMatch(freqS1,freqWindow)) {
                return true;
            }

            freqWindow[s2.charAt(i)-'a']--;
            freqWindow[s2.charAt(s1.length()+i)-'a']++;
        }

        //Check last window match
        return isFrequencyMatch(freqS1,freqWindow);
    }

    boolean isFrequencyMatch(int[] freq1, int[] freq2) {
        for(int i=0;i<26;i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
