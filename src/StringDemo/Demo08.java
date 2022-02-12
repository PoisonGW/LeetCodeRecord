package StringDemo;

/**
 * @description:
 * 外观数列
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
 * @author: Poison
 * @date: 2022年2月12日 21:51:57
 */
public class Demo08 {
    public static void main(String[] args) {
        new Demo08().countAndSay(4);
    }
    public String countAndSay(int n) {
        /**
         * 递归求解
         */
        //递归结束条件
        if(n == 1){
            return "1";
        }
        //进行递归
        String s = countAndSay(n-1);
        //构建描述字符串
        //使用StringBuilder构建返回值
        StringBuilder res = new StringBuilder();
        //定义计数器
        char temp = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            //如果是相同字符就找到最终相同的个数
            if(temp == s.charAt(i)){
                count++;
            }
            else{
                //如果不相同找到不相同的了就把前面的构建到返回结果上
                res.append(count).append(temp);
                //更新下一次需要记录的数量和字符
                count = 1;
                temp = s.charAt(i);
            }
        }
        //不要忘了加上最后比较的
        res.append(count).append(temp);
        System.out.println(res.toString());
        return res.toString();
    }
    public String countAndSay2(int n) {
        /**
         * 非递归求解
         */
        //使用StringBuilder构建返回值,第一个是“1”
        StringBuilder res = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            //表示前一个
            String prev = res.toString();
            //找下一个时要重置res
            res = new StringBuilder();
            //定义计数器
            char temp = prev.charAt(0);
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                //如果是相同字符就找到最终相同的个数
                if(temp == prev.charAt(j)){
                    count++;
                }
                else{
                    //如果不相同找到不相同的了就把前面的构建到返回结果上
                    res.append(count).append(temp);
                    //更新下一次需要记录的数量和字符
                    count = 1;
                    temp = prev.charAt(j);
                }
            }
            //不要忘了加上最后比较的
            res.append(count).append(temp);
        }
        System.out.println(res.toString());
        return res.toString();
    }
}
