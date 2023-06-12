package StringDemo;


import javax.annotation.processing.SupportedAnnotationTypes;

/**
 * @description: 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。如果是空字符串返回0.
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * @author: Poison
 * @date: 2022年1月28日 20:23:56
 */
public class Demo07 {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "ababc";


        int i = new Demo07().strStr4(s1, s2);
        int[] a = new int[5];
        String s = "ababc";
        //new Demo07().getNext(s,a);
        System.out.println(i);
    }

    /**
     * 解法1：逐个判断
     * @param haystack 给出的目标字符串
     * @param needle   要匹配的字符串
     * @return 第一次出现的位置
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int i=0;
        int j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
            if(j==needle.length()){
                return i-j;
            }
        }
        return -1;
    }
    /**
     * 解法2：使用java内置api
     * @param haystack 给出的目标字符串
     * @param needle   要匹配的字符串
     * @return 第一次出现的位置
     */
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    /**
     * 解法3：截取主串长度和要匹配的字符串相等，依次比较
     * @param haystack 给出的目标字符串
     * @param needle   要匹配的字符串
     * @return 第一次出现的位置
     */
    public int strStr3(String haystack, String needle) {
        int len = needle.length();
        int count = haystack.length()-len+1;
        for (int i = 0; i < count; i++) {
            if(haystack.substring(i,i+len).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    /**
     * 解法4：KMP算法
     * https://www.bilibili.com/video/BV18k4y1m7Ar?from=search&seid=11086108925154781855&spm_id_from=333.337.0.0
     * 快速在给定的字符串中匹配字符串是KMP算法的最经典体现。
     * KMP算法主要思想就是利用已经匹配了的部分子串减少回溯次数。
     *
     *
     * 字符串前缀：以第一个字符开头，并且不包含最后一个字符的连续子串
     *字符串后缀：以最后一个字符结尾，并且不包含第一个字符的连续子串。
     *
     * 使用KMP算法构造了一个next数组,该数组中存放的就是第i个位置前的字符串中最长的相同的字符串前缀和后缀的长度。
     * 构建实例：abacab
     * 0 前面没有字符串，故为0(任意字符串0位置皆为0)
     * 1 a 前缀是q，没有后缀，也是0
     * 2 ab 前缀是a 后缀是b ，不相等，也是0
     * 3 aba 存在相同前缀和后缀a 长度为1
     * 4 abac 后缀始终有c 所以长度为0
     * 5 abacb 长度也为0
     *
     * 求这个长度有什么用呢？
     * 来看一个栗子：
     * 判断abcabacdabacab中是否含有abacab
     *
     *
     *
     *
     * @param haystack 给出的目标字符串
     * @param needle   要匹配的字符串
     * @return 第一次出现的位置
     */
    public int strStr4(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next = new int[needle.length()];
        //获取next数组
        getNext(needle,next);
        //初始化指针
        int i = 0;
        for (int j = 0; j < haystack.length(); j++) {
            //如果不相等。进行回溯
            while(i>0 && haystack.charAt(j)!=needle.charAt(i)){
                i = next[i-1];
            }
            //如果相等，i++
            if(haystack.charAt(j)==needle.charAt(i)){
                i++;
            }
            //如果i到了最后一位，说明匹配到了
            if(i==needle.length()){
                return j-needle.length()+1;
            }
        }
        return -1;
    }
    public void getNext(String pattern,int[] next){
        //初始化
        int len = 0;
        for (int pos = 1; pos < pattern.length(); pos++) {
            //如果没有相同前后缀,向前回退
            while(len>0 && pattern.charAt(len)!=pattern.charAt(pos)){
                len = next[len-1];
            }
            //如果有相同前后缀，len++
            if(pattern.charAt(len)==pattern.charAt(pos)){
                len++;
            }
            next[pos] = len;
        }
    }
}
