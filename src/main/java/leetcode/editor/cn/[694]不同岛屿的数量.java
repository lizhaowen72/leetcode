package leetcode.editor.cn;
//给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。 
//
// 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。 
//
// 
//
// 样例 1: 
//
// 11000
//11000
//00011
//00011
// 
//
// 给定上图，返回结果 1。 
//
// 
//
// 样例 2: 
//
// 11011
//10000
//00001
//11011 
//
// 给定上图，返回结果 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, m
//onospace">3</font>。 
// 
//注意: 
//
// 11
//1
// 
//
// 和 
//
//  1
//11
// 
//
// 是不同的岛屿，因为我们不考虑旋转、翻转操作。 
//
// 
//
// 注释 : 二维数组每维的大小都不会超过50。 
// Related Topics 深度优先搜索 哈希表

import java.util.HashSet;

class NumberOfDistinctIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfDistinctIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            HashSet<String> set = new HashSet<>();
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 0)
                        continue;
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, row, col, sb);
                    set.add(sb.toString());
                }
            }
            return set.size();
        }

        public void dfs(int[][] grid, int row, int col, StringBuilder sb) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1)
                return;

            grid[row][col] = 0;
            dfs(grid, row + 1, col, sb.append("d"));// 下
            dfs(grid, row, col + 1, sb.append("r"));// 右
            dfs(grid, row - 1, col, sb.append("u"));// 上
            dfs(grid, row, col - 1, sb.append("l"));// 左
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}