import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinChange {
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 4, 5));
        System.out.println(minChange(7, coins));
    }

    static int minChange(int amount, List<Integer> numbers) {
        return minChange(amount, numbers, new HashMap<Integer, Integer>());
    }

    static int minChange(int amount, List<Integer> numbers, HashMap<Integer,Integer> memo){
        if(amount == 0){
            return 1;
        }

        if(amount < 0){
            return -1;
        }

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        int minCoin = -1;
        for(int num: numbers){
            int rem = amount - num;
            int subNumbers = minChange(rem, numbers, memo);
            if(subNumbers != -1){
                int numCoin = subNumbers + 1;
                if(numCoin < minCoin || minCoin == -1){
                    minCoin = numCoin;
                }
            }
        }
        memo.put(amount, minCoin);
        return minCoin;
    }
}
