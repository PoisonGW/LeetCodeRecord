package StringDemo;

/**
 * @description:
 * @author: Poison
 * @date: 2021年12月16日 21:31:49
 */
public class Demo02 {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(reverse(n));
    }
    public static int reverse(int x) {
        /*
        解法1：直接反转每个数字
         */
        int res=0;
        while(x!=0){
            //如果溢出就返回0
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res=x%10+res*10;
            x/=10;
        }
        return res;
    }
}
