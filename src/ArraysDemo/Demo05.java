package ArraysDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]
 * 输出: 1
 * 链接：
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * @author: Poison
 * @date: 2021年12月13日 20:53:01
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        /*
        解法1：先对数组进行排序，利用count记录每个数出现的次数。
         */
        //先判断如果只有一个元素，则直接返回该元素
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        int len = nums.length;
        int i=0;
        for (; i < len-1; i++) {
            int count = 1;
            if(nums[i]==nums[i+1]){
                count++;
                i++;

            }
            if(count<2){
                break;
            }
        }
        if(i>=len){
            return -1;
        }
        return nums[i];
    }

    public static int singleNumber2(int[] nums){
        /*
        解法2：异或运算
         */
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
    public static int singleNumber3(int[] nums){
        /*
        解法3：使用set集合特性
         */
        Set<Integer> hashSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if(!hashSet.add(nums[i])){
                hashSet.remove(nums[i]);
            }
        }
        return (int)hashSet.toArray()[0];

    }

}
/**
 * 思想：
 * 1.先排序，使用count记录该元素出现的次数。
 * count初值为1，比较相邻的元素，如果相等就count++,并且跳过下一个元素。如果不相等就判断count是否<2,如果小于2，则返回该元素。
 * 2.位运算
 *异或运算规律：a^b^a = a^a^b = b
 * 将所有元素进行异或运算，最后得到的值就是要返回的值。
 * 3.使用set集合特性
 * 把每个元素加入set中，如果添加失败，则说明以前添加过，就把该元素从集合中删除，最后set集合中剩余的那个元素就是需要的元素。
 */