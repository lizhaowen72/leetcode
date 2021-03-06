package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map
public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        int[] nums = {1, 2, 3, 4, 1};
        solution.containsNearbyAlmostDuplicate(nums, 3, 0);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k < 1 || t < 0) return false;
            Map<Long, Long> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
                long bucket = remappedNum / ((long) t + 1);
                if (map.containsKey(bucket)
                        || map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t
                        || map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) {
                    return true;
                }
                if (map.entrySet().size() >= k) {
                    long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                    map.remove(lastBucket);
                }
                map.put(bucket, remappedNum);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}