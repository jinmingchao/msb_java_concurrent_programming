package algorithm.algorithem;

import java.util.Random;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class App_20240325 {



    public int minSubArrayLen(int target, int[] nums) {
        Random r = new Random();
        r.nextInt();
        int len = nums.length;
        int res = len + 1;
        int left = 0, right = 0, sum = 0;
        while (left < len) {
            if (sum < target) {
                if (right < len) {
                    sum += nums[right++];
                } else {
                    break;
                }
            } else {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }


        return res == len + 1? 0 : res;
    }

}
