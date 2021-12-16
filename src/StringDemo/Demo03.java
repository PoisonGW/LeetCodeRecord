package StringDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * @author: Poison
 * @date: 2021年12月16日 22:25:50
 */
public class Demo03 {
    public static void main(String[] args) {
        String s = "leetcode";
        int i = firstUniqChar1(s);
        System.out.println(i);
    }
    public static int firstUniqChar(String s) {
        /*
        解法1：暴力循环
         */
        for (int i = 0; i < s.length(); i++) {
            boolean flag=true;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j) && i!=j){
                    flag=false;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar1(String s){
        /*
        解法2：使用一个长度为26的数组进行计数
         */
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            count[index]+=1;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            if(count[index]==1){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar2(String s){
        /*
        解法3：哈希表 字母保存为k，出现的次数保存为value,思想和使用数组相同
         */
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar3(String s){
        /*
        解法4：如果indexof和lastindexof相同,那么这个元素肯定只有一个
         */
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(s.indexOf(ch)==s.lastIndexOf(ch)){
                return i;
            }
        }
        return -1;
    }
}
