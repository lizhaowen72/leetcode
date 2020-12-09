package leetcode.editor.en;
//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search 
// 👍 3839 👎 91

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        root.left=left;
        root.right=right;
        left.left=node3;
        left.right=node4;
        right.left=node5;
        right.right=node6;
        List<List<Integer>> res = solution.levelOrder(root);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            levelHelper(res, root, 0);
            return res;
        }

        /**
         * res中表示每一层中节点.val的集合sublist,height相当于sublist在res的索引
         * @param res
         * @param root
         * @param height
         */
        public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
            if (root == null) return;
            if (height == res.size()) {
                res.add(new LinkedList<Integer>());
            }
            res.get(height).add(root.val);
            levelHelper(res, root.left, height + 1);
            levelHelper(res, root.right, height + 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
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
}