package leetcode.editor.cn;
//翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 522 👎 0


import java.util.LinkedList;
import java.util.Queue;

class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * bfs解法
         * node [1,2,3]
         * left[2] right[3]
         * left=3
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
//                TreeNode leftNode = node.left;
//                node.left = node.right;
//                node.right = leftNode;
                // 缓存rightNode，换成leftNode也是一样的
                TreeNode rightNode = node.right;
                node.right = node.left;
                node.left = rightNode;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return root;
        }

        /**
         * dfs解法
         *
         * @param root
         * @return
         */
        public TreeNode invertTreeBYDFS(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = root.left, right = root.right;
            root.left = invertTreeBYDFS(right);
            root.right = invertTreeBYDFS(left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}