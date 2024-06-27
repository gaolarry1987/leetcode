public class ReverseDigit {
    static int sum = 0;
    static int reverse(int n){
        if(n == 0){
            return sum;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        return reverse(n/10);
    }
    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }
}
