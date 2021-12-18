package StringDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * @author: Poison
 * @date: 2021年12月18日 17:36:04
 */
public class Demo04 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram1(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        /*
        解法1：使用两个数组存储两个字符串每个字母出现的次数，依次进行比较。
         */
        //先判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            s1[index] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            index = t.charAt(i) - 'a';
            t1[index] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        /*
        解法2：利用map，存储两个字符串中每个字母出现的次数。
         */
        //先判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Character c : map1.keySet()) {
            if (map2.get(c) == null || !map1.get(c).equals(map2.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        /*
        解法3：计算两个字符串字符的差值
         */
        //先判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            count[index] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            index = t.charAt(i) - 'a';
            //如果等于0，则说明另一个字符串没有该字符，如果不为0，则减一
            if (count[index] == 0) {
                return false;
            } else {
                count[index]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        /*
        解法4：先排序再比较
         */
        //先判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
    public static boolean isAnagram4(String s, String t){
        /*
        解法5：字符抵消法。
         */
        //先判断两个字符串长度是否相等
        if (s.length() != t.length()) {
            return false;
        }
        //记录各个符出现的次数
        int[] n = new int[26];
        //记录两个字符串中不同字符的种类的数量。如果最后为0，说明两个字符串满足条件
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            //对应位置等于1,说明出现了新字符
            if(++n[s.charAt(i)-'a']==1){
                count++;
            }
            //等于0，说明没有该字符了
            if(--n[t.charAt(i)-'a']==0){
                count--;
            }
        }
        return count==0;
    }
}
