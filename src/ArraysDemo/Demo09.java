package ArraysDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个整数数组 nums和一个整数目标值 target,请你在该数组中找出 为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * @author: Poison
 * @date: 2021年12月14日 21:21:53
 */
public class Demo09 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum1(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        /*
        解法1：暴力循环
         */
        int i = 0;
        int j = 1;
        for (i = 0; i < nums.length-1; i++) {
            int n = target - nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if(nums[j] == n){
                    int[] arr = new int[]{i,j};
                    return arr;
                }
            }
        }
        return null;
    }
    public static int[] twoSum1(int[] nums, int target){
        /*
        解法2：使用hashMap
         */
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i])!=null){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
/*
思想：
1.暴力求解
遍历数组，两数相加如果有等于目标元素的就保存下表并退出。
2.使用HashMap
把值作为key，下标作为value，如果已存入的map中包含target-当前元素的值，返回即可
 */