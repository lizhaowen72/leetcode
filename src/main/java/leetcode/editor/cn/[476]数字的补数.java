package leetcode.editor.cn;
//给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: 5
//输出: 2
//解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
// 
//
// 示例 2: 
//
// 输入: 1
//输出: 0
//解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
// 
//
// 
//
// 注意: 
//
// 
// 给定的整数保证在 32 位带符号整数的范围内。 
// 你可以假定二进制数不包含前导零位。 
// 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同 
// 
// Related Topics 位运算 
// 👍 189 👎 0
/**
 * for example :
 * 100110,its complement is 011001,the sum is 111111.So we only need get the min number large or equal to num,
 * then do substraction
 */
class NumberComplement{
      public static void main(String[] args) {
           Solution solution = new NumberComplement().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
            int i = 0, j = 0;
            while (i < num) {
                i += Math.pow(2, j);
                j++;
            }
            return i - num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}