package leetcode.editor.en;
//Given a sorted array nums, remove the duplicates in-place such that each eleme
//nt appears only once and returns the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
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
//int len = removeDuplicates(nums);
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
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2]
//Explanation: Your function should return length = 2, with the first two elemen
//ts of nums being 1 and 2 respectively. It doesn't matter what you leave beyond t
//he returned length.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter 
//what values are set beyond the returned length.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in ascending order. 
// 
// Related Topics Array Two Pointers 
// 👍 3199 👎 6042

class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {1, 1, 2};
        solution.removeDuplicates(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[slow] != nums[i]) {
                    // 要覆盖slow的后一个,因此slow要加一,比如[1,1,2], 2要覆盖第二个1,保留第一个1
                    // (1) 和 (2)的顺序不能颠倒
                    slow++; // (1)
                    nums[slow] = nums[i];// (2)
                }
            }
            return slow + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}