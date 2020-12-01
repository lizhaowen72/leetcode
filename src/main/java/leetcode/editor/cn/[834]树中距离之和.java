package leetcode.editor.cn;
//给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
//
// 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
//
// 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
//
// 示例 1: 
//
// 
//输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 
//如下为给定的树的示意图：
//  0
// / \
//1   2
//   /|\
//  3 4 5
//
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 说明: 1 <= N <= 10000 
// Related Topics 树 深度优先搜索 
// 👍 236 👎 0

import java.util.ArrayList;
import java.util.HashSet;

class SumOfDistancesInTree {
    public static void main(String[] args) {
        Solution solution = new SumOfDistancesInTree().new Solution();
        int  N = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] res, count;
        ArrayList<HashSet<Integer>> tree;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            tree = new ArrayList<HashSet<Integer>>();
            res = new int[N];
            count = new int[N];
            for (int i = 0; i < N; i++) {
                tree.add(new HashSet<Integer>());
            }
            for (int[] edge : edges) {
                tree.get(edge[0]).add(edge[1]);
                tree.get(edge[1]).add(edge[0]);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return res;
        }

        public void dfs(int root, int pre) {
            for (int i : tree.get(root)) {
                if (i == pre) {
                    continue;
                }
                dfs(i, root);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
            count[root]++;
        }

        public void dfs2(int root, int pre) {
            for (int i : tree.get(root)) {
                if (i == pre) {
                    continue;
                }
                res[i] = res[root] - count[i] + count.length - count[i];
                dfs2(i, root);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}