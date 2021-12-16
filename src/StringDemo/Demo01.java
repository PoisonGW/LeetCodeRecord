package StringDemo;

import java.util.Arrays;

/**
 * @description:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * @author: Poison
 * @date: 2021年12月16日 21:10:08
 */
public class Demo01 {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o','j'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        /*
        解法1：双指针,前后两两交换即可
         */
        int j=s.length-1;
        for (int i = 0; i < j; i++,j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }
    public static void reverseString2(char[] s){
        /*
        解法2：递归。递归进行两两交换
         */
        if(s==null || s.length==0){
            return;
        }
        reverse(s,0,s.length-1);
    }

    private static void reverse(char[] s, int left, int right) {
        if(left>=right){
            return ;
        }
        //顺序可以和swap交换
        reverse(s,left+1,right-1);
        swap(s,left,right);
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
