package bfs.the_minimum_depth_of_a_binary_tree;

/**
 * 树节点
 *
 * @author Poison
 * @date 2023/06/12
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
