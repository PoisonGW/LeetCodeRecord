package ArraysDemo;

import java.util.Arrays;

/**
 * @description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * @author: Poison
 * @date: 2021年12月14日 19:21:35
 */
public class Demo07 {
    public static void main(String[] args) {
        int[] digits = new int[]{1,9,9};
        int[] ints = plusOne1(digits);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] plusOne(int[] digits) {
        /*
        解法1：创建新数组
         */
        int[] arr = new int[digits.length+1];
        int index= digits.length;
        digits[digits.length-1]+=1;
        int carry = 0;
        for (int i = digits.length-1; i >=0 ; i--) {
            arr[index--] = (carry+digits[i])%10;
            carry=(carry+digits[i])/10;
        }
        if(carry==0){
            arr = Arrays.copyOfRange(arr, 1, arr.length);
        }else{
            arr[0]=1;
        }
        return arr;
    }
    public static int[] plusOne1(int[] digits){
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }else{
                digits[i]=0;
            }
        }
        int[] temp = new int[digits.length+1];
        temp[0] = 1;
        return temp;
    }
}
/*
  思想：
  1.建立一个新数组，长度比原数组大1。
  先给最后一位加1，逐位判断是是否产生进位。然后将产生的进位与原数组中的值进行相加并%10，保存到新数组中。
  如果最后的进位是1，说明最高位为1，否则为0，这时需要对数组进行处理。可以使用Arrays.CopyOf
  2.先对原数组进行判断有多少个9
  如果最后一位不是9，直接加1返回即可
  如果最后若干位都是9，把9全部变为0，然后把第一个不为9的数+1，然后返回
  如果全都是9，那么要构造一个新数组，第一位是1，其他都是0；
 */