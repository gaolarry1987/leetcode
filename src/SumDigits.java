public class SumDigits {
    public static void main(String[] args) {
        int num = 20987;
        System.out.println(sum(num));
    }

    static int sum(int n){
        if(n == 0){
            return 0;
        }
        return n%10 + sum(n/10);
    }
}
