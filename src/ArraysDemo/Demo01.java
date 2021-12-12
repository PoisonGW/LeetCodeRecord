package ArraysDemo;

/**
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * @author: Poison
 * @date: 2021年12月12日 16:22:27
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int i = Demo01.removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        /*
        首先考虑边界问题,为null或长度为0
         */
        if(nums==null || nums.length==0){
            return 0;
        }

        int pos=0;
        int next=1;
        while(next<nums.length){
            if(nums[pos]!=nums[next]){
                pos++;
                if(next-pos>0){
                    nums[pos] = nums[next];
                }
            }
            next++;
        }
        return pos+1;
    }
}

/**
 * 思想：
 * 使用两个指针分别为pos和next，pos指针指向当前位置，next指针一直向后找，直到找到和当前位置不同的元素。
 * 然后把pos++,把该元素放到pos的位置。(这里可以做一个判断来进行优化，如果两个元素是相邻的就不必赋值)
 * 结束后的pos+1就是要返回的数组长度
 */
