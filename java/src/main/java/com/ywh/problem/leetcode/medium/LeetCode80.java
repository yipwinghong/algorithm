package com.ywh.problem.leetcode.medium;

/**
 * 删除排序数组中的重复项 II
 * [数组] [双指针]
 *
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 *      为什么返回数值是整数，但输出的答案是数组呢？
 *      请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *      你可以想象内部操作如下：
 *          // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 *          int len = removeDuplicates(nums);
 *
 *          // 在函数里修改输入数组对于调用者是可见的。
 *          // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 *          for (int i = 0; i < len; i++) {
 *              print(nums[i]);
 *          }
 * 示例 1：
 *      输入：nums = [1,1,1,2,2,3]
 *      输出：5, nums = [1,1,2,2,3]
 *      解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *      输入：nums = [0,0,1,1,1,1,2,3,3]
 *      输出：7, nums = [0,0,1,1,2,3,3]
 *      解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
 * 提示：
 *      0 <= nums.length <= 3 * 10^4
 *      -10^4 <= nums[i] <= 10^4
 *      nums 按递增顺序排列
 *
 * @author ywh
 * @since 2020/9/21/021
 */
public class LeetCode80 {

    /**
     * Time: O(n), Space: O(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        // 两个指针，l 指向下一个要覆盖元素的位置，r 指向当前元素，cnt 统计当前元素出现次数。
        int l = 1, r = 1, cnt = 1;
        for (; r < nums.length; r++) {
            // 如果当前元素与其上一个元素相同，则统计 +1，否则重置为 1。
            cnt = nums[r] == nums[r - 1]? cnt + 1: 1;

            // 如果当前元素数量小于等于 2，表示没有重复或只重复一次。则将其拷贝到 l 的位置，并移动 l。
            if (cnt <= 2) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}
