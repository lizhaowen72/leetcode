package leetcode.editor.en;
//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
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
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics Stack Tree Breadth-first Search 
// 👍 2798 👎 113

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        solution.zigzagLevelOrder(root);
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            levelHelp(res,root,0);
            return res;
        }
        public void levelHelp(List<List<Integer>> res,TreeNode root,int height){
            if (root==null) return;
            if (height==res.size()){
                res.add(new ArrayList<Integer>());
            }
            if (height%2!=0){
                res.get(height).add(0,root.val);
            }else{
                res.get(height).add(root.val);
            }
            levelHelp(res,root.left,height+1);
            levelHelp(res,root.right,height+1);
        }


        public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
            TreeNode curr = root;
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(curr);
            int level = 0;
            while (!queue.isEmpty()) {
                List<Integer> subRes = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }
                    if(level%2==0){
                        subRes.add(0,queue.poll().val);
                    }else{
                        subRes.add(queue.poll().val);
                    }

                }
                res.add(subRes);
                level++;
            }
            return res;
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