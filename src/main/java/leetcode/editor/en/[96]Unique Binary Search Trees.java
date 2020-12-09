package leetcode.editor.en;
//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Dynamic Programming Tree 
// 👍 4055 👎 147

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            return genTreeNums(1, n);
        }

        private int genTreeNums(int start, int end) {
            int res = 0;
            if (start >= end) {
                return 1;
            }
            for (int i = start; i <= end; i++) {
                int leftTreeNums = genTreeNums(start, i - 1);
                int rightTreeNums = genTreeNums(i + 1, end);
                res += leftTreeNums * rightTreeNums;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}