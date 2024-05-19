package msb_algorithm.algorithem;

import java.util.Random;

public class App_20240326_quickSort {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        Random r = new Random();
        int pos = left + r.nextInt(right - left + 1);
        int[] bounds = partition(left, right, pos, nums);
        quickSort(nums,  left, bounds[0]);
        quickSort(nums,  bounds[1], right);

    }

    private int[] partition(int left, int right, int pos, int[] nums) {
        int cur = left, l = left, r = right;
        int val = nums[pos];
        while (cur <= r) {
            if (nums[cur] < val) {
                exchange(nums, l++, cur++);
            } else if (nums[cur] == val) {
                cur++;
            } else {
                exchange(nums, r--, cur);
            }
        }
        return new int[]{l - 1, r + 1};
    }

    void exchange(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
