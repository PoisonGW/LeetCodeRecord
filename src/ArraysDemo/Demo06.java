package ArraysDemo;

import java.util.*;

/**
 * @description:
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * @author: Poison
 * @date: 2021年12月13日 21:28:13
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{1,1};
        int[] ints = intersect2(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        /*
        解法1：暴力循环
         */
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    res.add(nums1[i]);
                    nums2[j] = -nums2[j];
                    break;
                }
            }
        }
        int[] arr = new int[res.size()];
        int index=0;
        for (int i = 0; i < res.size(); i++) {
            arr[index++] = res.get(i);
        }
        return arr;
    }
    public static int[] intersect1(int[] nums1, int[] nums2){
        /*
        解法1：排序+双指针
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer> res = new ArrayList();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] arr = new int[res.size()];
        int index=0;
        for (int p = 0; p < res.size(); p++) {
            arr[index++] = res.get(p);
        }
        return arr;
    }
    public static int[] intersect2(int[] nums1, int[] nums2){
        /*
        解法3：使用map
         */
        if(nums1.length>nums2.length){
            return intersect2(nums2,nums1);
        }
        int[] res = new int[nums1.length];
        int index=0;
        Map<Integer,Integer> map = new HashMap<>(1068);
        //800/0.75+1 = 1068
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.getOrDefault(nums2[i],0)>0){
                res[index++] = nums2[i];
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
/**
 * 思想：
 * 1.暴力循环，逐个判断元素是否存在于另一个数组中，
 * 如果存在则把该元素放到返回的数组中，并且把该元素赋值为-1，以免影响后面的判断
 * 2.排序+双指针
 * 首先对两个数组进行排序。两个指针分别指向数组的首部。
 * 如果两个指针指向的值相同，则把该元素放入到返回的数组中。
 * 如果不同，则把两个指针指向的更小的元素往后挪一位。
 * 3.使用map
 * 找出两个数组中长度最小的以减少时间复杂度。
 * 把数组1的元素逐个加入到map中，key为元素值，value初始值为1，如果后面还有则把value++，即value表示数组中重复元素的个数
 * 遍历数组2，如果map中包含该元素，并且value值大于0，就把value--，然后把该元素放入到数组中。
 *
 */