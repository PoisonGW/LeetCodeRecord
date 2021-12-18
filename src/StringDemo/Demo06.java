package StringDemo;

/**
 * @description: 请你来实现myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 * @author: Poison
 * @date: 2021年12月18日 20:29:37
 */
public class Demo06 {
    public static void main(String[] args) {
        String s = ".1";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        /*
        1.先去除前导空格
        2.再判断有无正负号
        3.遇到字母停止(如果不是".")
        4.判断是否大于整数最大值或小于整数最小值
        5.返回结果
         */
        s = s.trim();
        if(s.length()==0){
           return 0;
        }
        int flag = 1;
        int i = 0;
        char c = s.charAt(0);
        if (c == '-' || c =='+') {
            if(c=='-'){
                flag=-1;
            }
            i=1;
        }
        int sum = 0;
        for (; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //越界处理
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                sum = sum * 10 + digit;
            }

        }
        return sum * flag;
    }
}
