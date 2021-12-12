package ArraysDemo;

import java.util.Arrays;
import java.util.Collections;

/**
 * @description: 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @author: Poison
 * @date: 2021年12月12日 17:36:37
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,};
        rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        /*
        解法1：把旋转k个位置进行分解：即每次轮转一个位置，轮转k次
         */
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }


    }

    public static void rotate1(int[] nums, int k) {
    /*
      解法2：利用临时数组
    */
        int length = nums.length;
        //就算这里加了这一句后面还是要进行除余运算，否则仍有可能超出数组长度，但是可以让后面的运算小一些，因为k可能会很大
        k=k%length;
        int[] n = Arrays.copyOf(nums,length);
        for (int i = 0; i < length; i++) {
            nums[(i+k)%length] = n[i];
        }
    }
    public static void rotate2(int[] nums, int k){
        /*
        解法3：数组反转
         */
        int length = nums.length;
        reverse(nums,0, length-1);
        reverse(nums,0, (k%length)-1);
        reverse(nums,k%length, length-1);
    }
    public static void reverse(int[] nums,int s,int e){
        while(s<e){
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }
    public static void rotate3(int[] nums, int k){
        /*
        解法4：循环数组
         */
        int length = nums.length;
        k = k%length;
        int index = 0;
        int pos = nums[0];
        boolean[] b = new boolean[length];
        for(int i=0;i<length;i++){
            index = (index+k)%length;
            if(b[index]){
                index=(index+1)%length;
                pos = nums[index];
                i--;
            }
            else{
                b[index] = true;
                int temp = nums[index];
                nums[index] = pos;
                pos = temp;
            }
        }
    }
}
/**
 * 思想：
 * 1.把旋转k个位置进行分解：即每次轮转一个位置，轮转k次（可能会超时）
 * 先对k进行处理，k如果是数组长度的n倍，那么相当于没旋转。
 * 把最后一个保存下来，每个元素依次向后挪，最后把最后一个元素放到第一位。
 * 注意要倒着挪！！！
 * 2.利用临时数组
 * 先对k进行处理，k如果是数组长度的n倍，那么相当于没旋转。
 * 用临时数组存放原数组，逐个放回去时把每个元素右移k位。
 * 3.数组反转
 *1)先把整个数组进行反转
 *2)再把前k个元素进行反转
 *3)再把后面元素进行反转
 * 上面顺序可以调换，但是原理一样。
 * 4.循环数组
 * 把数组当作一个环形数组。
 * 先把第k位的元素保存下来，然后第一个元素右移k位。
 * 把第2k位的元素保存下来，把上次保存的第k位元素，继续右移k位，放到2k位置，
 * 剩下元素依次进行，每个元素都要移动，总共进行数组的长度的次数。
 * 如果遇到数组长度为k的整数倍，就会出现原地打转的情况。所以要判断元素是否被访问过，
 * 如果被访问过就把index++，并且更新当前位置，相当于重新从0开始进行操作
 */