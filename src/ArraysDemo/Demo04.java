package ArraysDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * @author: Poison
 * @date: 2021年12月13日 19:46:07
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,};
        boolean b = containsDuplicate2(nums);
        System.out.println(b);
    }
    public static boolean containsDuplicate(int[] nums) {
        /*
        解法1：利用数组存储出现次数
         */
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsDuplicate1(int[] nums) {
        /*
        解法2：先排序。再比较相邻元素
         */
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        /*
        解法3：利用set集合的特性，不能存放重复元素
         */
        int length = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if(!hashSet.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
/**
 * 思想：
 * 1.暴力循环
 * 2.利用排序，先把数组排好序，如果有重复元素，那么相邻的元素会相等，依次比较相邻的元素即可。
 * 3.利用set集合，set集合不允许存在重复元素，如果有重复元素加入时会返回false，对此进行判断即可。
 */
