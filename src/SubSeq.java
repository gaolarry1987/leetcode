import java.util.ArrayList;
import java.util.List;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");
        System.out.println(subString("", "abc"));
    }

    static void subseq(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        subseq(processed + ch, unprocessed.substring(1));
        subseq(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subString (String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subString(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subString(processed,unprocessed.substring(1));

        left.addAll(right);
        return left;
     }
}
