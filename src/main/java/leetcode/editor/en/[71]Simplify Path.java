package leetcode.editor.en;
//Given an absolute path for a file (Unix-style), simplify it. Or in other words
//, convert it to the canonical path. 
//
// In a UNIX-style file system, a period '.' refers to the current directory. Fu
//rthermore, a double period '..' moves the directory up a level. 
//
// Note that the returned canonical path must always begin with a slash '/', and
// there must be only a single slash '/' between two directory names. The last dir
//ectory name (if it exists) must not end with a trailing '/'. Also, the canonical
// path must be the shortest string representing the absolute path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: path = "/a/./b/../../c/"
//Output: "/c"
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid Unix path. 
// 
// Related Topics String Stack 
// 👍 974 👎 1987

import java.util.*;

class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> deque = new LinkedList<>();
            Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
            for (String dir : path.split("/")) {
                if (dir.equals("..") && !deque.isEmpty()) { // 如果dir为..,则将目录切换到上一级,pop前要排除空指针
                    deque.pop();
                }
                if (!skip.contains(dir)) {
                    deque.push(dir);
                }
            }
            String res = "";
            for (String dir : deque) {
                res = "/" + dir + res;
            }
            return deque.isEmpty() ? "/" : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}