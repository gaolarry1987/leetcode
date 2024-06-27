public class CountZeros {
    public static void main(String[] args) {
        int num = 2009800;
        System.out.println(helper(num,0));
    }
    static int helper(int n, int c){
        if(n == 0){
            return c;
        }
        int rem = n%10;
        if(rem == 0){
            return helper(n/10,c+1);
        }
        else{
            return helper(n/10, c);
        }
    }
}
