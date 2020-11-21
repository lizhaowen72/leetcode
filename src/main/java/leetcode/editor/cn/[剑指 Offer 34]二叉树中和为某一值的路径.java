package leetcode.editor.cn;
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 70 👎 0

import java.util.ArrayList;
import java.util.List;

class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            helper(root, res, tempList, sum);
            return res;
        }

        private void helper(TreeNode root, List<List<Integer>> res, List<Integer> tempList, int sum) {
            if (root == null) return;
            tempList.add(root.val);
            if (root.left == null && root.right == null && root.val == sum) {
                res.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
                return;
            } else {
                helper(root.left, res, tempList, sum - root.val);
                helper(root.right, res, tempList, sum - root.val);
            }
            tempList.remove(tempList.size() - 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}