package base_algorithm.fibonacci_sequence;

/**
 * 斐波那契序列
 *
 * @author Poison
 * @date 2023/06/14
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib1(5));
    }

    /**
     * 动态规划解法  O(n)
     *
     * @param n n
     * @return int
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    /**
     * 矩阵快速幂  O(logn)
     *
     * @param n n
     * @return int
     */
    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        // 定义底数
        int[][] a = {{1, 1}, {1, 0}};
        // 计算n次幂
        int[][] res = pow(a, n - 1);
        // 最后乘以的矩阵是
        // | x y | | 1 |   | x |
        //        *      =       = x
        // | z w | | 0 |   | 0 |
        // 所以返回res[0][0]即可
        return res[0][0];
    }

    private static int[][] pow(int[][] a, int n) {
        // 定义单位1，此处为单位矩阵
        int[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            // 判断二进制是否为1，决定要不要加入result
            if ((n & 1) == 1) {
                res = multiply(res, a);
            }
            // 减半指数，减少相乘次数
            n >>= 1;
            // 平方底数 保证结果不变
            a = multiply(a, a);
        }
        return res;
    }

    /**
     * 2*2 矩阵相乘
     *
     * @param a 一个
     * @param b b
     * @return {@code int[][]}
     */
    private static int[][] multiply(int[][] a, int[][] b) {
        int MOD = 1000000007;
        int[][] res = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return res;
    }

}
