public class Permutation {
    public static void main(String[] args) {
        permutation("", "abc");
        System.out.println(permutationCount("", "abc"));
    }

    static void permutation(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        for(int i = 0; i <= processed.length(); i++){
            String f = processed.substring(0,i);
            String s = processed.substring(i, processed.length());
            permutation(f+ch+s,unprocessed.substring(1));
        }
    }

    static int permutationCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = unprocessed.charAt(0);

        for(int i = 0; i <= processed.length(); i++){
            String f = processed.substring(0,i);
            String s = processed.substring(i, processed.length());
            count = count + permutationCount(f+ch+s,unprocessed.substring(1));
        }
        return count;
    }
}
