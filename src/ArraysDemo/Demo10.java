package ArraysDemo;

/**
 * @description:
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * @author: Poison
 * @date: 2021年12月15日 19:36:43
 */
public class Demo10 {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }
    public static boolean isValidSudoku(char[][] board) {
        /*
        解法1：直接判断
         */
        int len = board.length;
        //保存每一行是否出现过该数字，这里的行对应原数组中的行，每一列的下标对应原数组中的每个格中的数字-1(下标是0开始)
        int[][] row = new int[len][len];
        //保存每一列是否出现过该数字，这里的每一行对应原数组的每一列，每一列的下标对应原数组中的每个格中的数字-1(下标是0开始)
        int[][] column = new int[len][len];
        //保存每个单元格是否出现郭该数字，每一行对应一个单元格(3*3)，每一列的下标对应原数组中的每个格中的数字-1(下标是0开始)
        int[][] cell = new int[len][len];
        //遍历数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                //把小格内的数字变成下标
                int num = board[i][j]-'0'-1;
                //p是第几个单元格，每行是3格单元格，从0开始
                int p = i/3*3+j/3;
                //如果当前数字当前行已经有了，或当前列已经有了，或当前数字所在单元格已经有了，就直接返回false
                if(row[i][num]!=0 || column[j][num]!=0 || cell[p][num]!=0){
                    return false;
                }
                row[i][num] = column[j][num] = cell[p][num] = 1;
            }
        }
        return true;
    }
    public static boolean isValidSudoku1(char[][] board){
        int len = board.length;
        int[] row = new int[len];
        int[] column = new int[len];
        int[] cell = new int[len];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                int shift = 1<<(board[i][j]-'0');
                int p = i/3*3 +j/3;
                if((row[i]&shift)>0 || (column[j]&shift)>0 || (cell[p]&shift)>0){
                    return false;
                }
                row[i] |=shift;
                column[j] |=shift;
                cell[p] |=shift;
            }
        }
        return true;
    }
}
/*
思想：
1.直接判断
建立三个二维数组，依次保存每一行是否出现过该数字，每一列是否出现过该数字，每个小单元格(3*3)是否出现过该数字
遍历二维数组，如果是"."就跳过，如果不是"."就判断是否出现过，如果没有出现过就记录下来。
2.位运算
为了节省空间，使用位运算来代替一维数组
把1和原数组中的每一位数字进行左移运算 例如：1<<4 10000 假如下一个元素是3 1<<3 1000 10000&1000 = 0说明没有该数字
                                              假如下一个元素是4 1<<4 10000 10000&10000 > 0 说明已经存在了该数字
如果不是相同的数字就把10000 | 1000 = 11000存入数组即可
也就是说每个数字对应一个1，相当于把左移后的数字当作了一个数组来使用。
 */