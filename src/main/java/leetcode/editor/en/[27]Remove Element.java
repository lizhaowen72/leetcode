package leetcode.editor.en;
//Given an array nums and a value val, remove all instances of that value in-pla
//ce and return the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// The order of elements can be changed. It doesn't matter what you leave beyond
// the new length. 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means a modificati
//on to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeElement(nums, val);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2]
//Explanation: Your function should return length = 2, with the first two elemen
//ts of nums being 2.
//It doesn't matter what you leave beyond the returned length. For example if yo
//u return 2 with nums = [2,2,3,3] or nums = [2,3,0,0], your answer will be accept
//ed.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elem
//ents can be arbitrary. It doesn't matter what values are set beyond the returned
// length.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 1758 👎 3119

class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        int[] nums = {3, 2, 2, 3};
        solution.removeElement(nums, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    // 要移除==val的值
                    // slow 表示的是!=val的值的索引
                    // 覆盖之后要slow+1
                    // (1) 与 (2) 顺序不能颠倒
                    nums[slow] = nums[i];// (1)
                    slow++;// (2)
                }
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}