package org.vbiso.leetcode.basic;

/**
 * 删除排序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * <p>
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * <p>
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 判题标准:
 * <p>
 * 系统会用下面的代码来测试你的题解:
 * <p>
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * <p>
 * int k = removeDuplicates(nums); // 调用
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode1 {
    
    public static void main(String[] args) {
        
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new Solution().removeDuplicates(nums);
        int[] expectedNums = new int[i];
        System.arraycopy(nums, 0, expectedNums, 0, i);
        assert i == expectedNums.length;
        for (int j = 0; j < i; j++) {
            assert nums[j] == expectedNums[j];
        }
    }
    
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[j] != nums[i]) {
                    nums[++j] = nums[i];
                }
            }
            return ++j;
        }
    }
}

/**
 * 题解
 * 双指针解法，
 * 以 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 举例，
 * j 表示新数组下标，i表示当前数组下标 当 nums[i] == nums[j] 时，i 向右移动，遇到不同的，则j 向左移动，并将nums[i]的值付给nums[j++]
 * 第一次交换
 * 0,1,1,1,1,2,2,3,3,4
 * 第二次交换
 * 0,1,2,1,1,2,2,3,3,4
 * 第三次交换
 * 0,1,2,3,1,2,2,3,3,4
 * ...
 */