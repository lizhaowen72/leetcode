package leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 717 👎 0

class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] nums = {-2, 3, 4};
        solution.maxProduct(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
           int r=nums[0];
            for (int i = 1,imax=r,imin=r; i <nums.length ; i++) {
                if (nums[i]<0){
                    int temp = imax;
                    imax=imin;
                    imin=temp;
                }
                imax= Math.max(nums[i],nums[i]*imax);
                imin = Math.min(nums[i],nums[i]*imin);
                r= Math.max(r,imax);
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}