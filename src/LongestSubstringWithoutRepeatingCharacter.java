import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "a,a,b,b,a,a,a,c,c";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charList = new HashSet<>();
        int l = 0;
        int sum = 0;

        for(int r = 0; r < s.length(); ++r){
            while(charList.contains(s.charAt(r))){
                charList.remove(s.charAt(l));
                l+=1;
            }
            charList.add(s.charAt(r));
            sum = Math.max(sum, r-l+1);
        }
        return sum;
    }
}
