package ArraysDemo;

import java.util.Arrays;

/**
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * @author: Poison
 * @date: 2021年12月14日 20:30:33
 */
public class Demo08 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes2(nums);
    }

    public static void moveZeroes(int[] nums) {
        int front = 0;
        while (front < nums.length && nums[front] != 0) {
            front++;
        }
        int rear = front + 1;
        while (rear < nums.length && nums[rear] == 0) {
            rear++;
        }
        while (rear < nums.length && front < nums.length) {
            while (front < nums.length && nums[front] != 0) {
                front++;
            }
            while (rear < nums.length && nums[rear] == 0) {
                rear++;
            }
            if (rear < nums.length && front < nums.length) {
                nums[front] = nums[rear];
                nums[rear] = 0;
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes1(int[] nums) {
        /*
        解法2：双指针
         */
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if(count!=0){
                nums[i-count] = nums[i];
                nums[i]=0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes2(int[] nums){
        /*
        解法3：把非0元素往前挪
        4, 2, 4, 0, 0, 3, 0, 5, 1, 0
         */
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[index++] = nums[i];
               if(index!=i+1){
                   nums[i] = 0;
               }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
/*
思想：
1.双指针
两个指针一个初始为front第一个0的位置，一个初始为rear为第一个不为0的位置
接着front指针寻找为值为0的元素，rear指针寻找值不为0的元素，找到就停下来等待另一个指针，都找到了就开始交换
要时刻判断数组是否越界！！！
2.双指针
两个指针count=0，i=0
count用来统计i前面0的个数，i是循环变量
如果i对应的值为0，就让count++
如果i对应的值不为0并且前面存在0，即count值不为0，就把当前的值放到第一个0的位置，即下标为i-count的位置，然后把当前位置赋值为0;
3.把非0元素往前挪
index=0,表示非0元素的当前位置
遍历数组，如果当前元素不为0，令nums[index++] = nums[i],如果i不等于index就把当前元素置为0。
 */