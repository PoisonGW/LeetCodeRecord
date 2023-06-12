package bfs.the_minimum_depth_of_a_binary_tree;


import java.util.*;

/**
 * 二叉树最小深度 leetCode Number 111
 *
 * @author Poison
 * @date 2023/06/12
 */
public class TheMinimumDepthOfBinaryTree {
    public static void main(String[] args) {
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历这一层的node，通过这一层的每一个node向向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 判断是否到达终点
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                // 将四周加入队列
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            // 到达下一层
            depth++;
        }
        return depth;
    }
}

