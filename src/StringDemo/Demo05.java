package StringDemo;

import java.util.Locale;

/**
 * @description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 链接：
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * @author: Poison
 * @date: 2021年12月18日 19:35:31
 */
public class Demo05 {
    public static void main(String[] args) {
        String s = ".,";
        System.out.println(isPalindrome1(s));
    }
    public static boolean isPalindrome(String s) {
        /*
        解法1：双指针
         */
        //如果是空串直接返回true
        if("".equals(s)){
            return true;
        }
        //先把所有字母转化为小写字母
        s=s.toLowerCase();
        int j=s.length()-1;
//        for (int i = 0; i < j; i++,j--) {
//            while(i<s.length()&&!((s.charAt(i)>='a' && s.charAt(i)<='z') ||(s.charAt(i)>='0'&&s.charAt(i)<='9'))){
//                i++;
//            }
//            while(j>=0&&!((s.charAt(j)>='a' && s.charAt(j)<='z') ||(s.charAt(j)>='0'&&s.charAt(j)<='9'))){
//                j--;
//            }
//            if(i<s.length()&&j>=0 &&s.charAt(i)!=s.charAt(j)){
//                return false;
//            }
//        }
        //优化，使用java自带api
        for (int i = 0; i < j; i++,j--) {
            while(i<j&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome1(String s){
        /*
        解法2：使用正则表达式
         */
        s=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String s1 = new StringBuffer(s).reverse().toString();
        return s.equals(s1);
    }
}
