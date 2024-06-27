import java.util.HashMap;
import java.util.HashSet;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fiboNum(4));
        System.out.println(fiboNum(8));
        System.out.println(fiboNum(1000));
    }

    static int fiboNum(int n){
        return fiboNum(n, new HashMap<>());
    }


    static int fiboNum(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = fiboNum(n - 1, memo) + fiboNum(n - 2, memo);
        memo.put(n, result);
        return result;

    }
}
