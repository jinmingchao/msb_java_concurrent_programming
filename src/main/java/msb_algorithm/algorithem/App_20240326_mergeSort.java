package msb_algorithm.algorithem;

public class App_20240326_mergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);

    }

    int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = left + (right - left) / 2;
        int[] nums1 = mergeSort(nums, left, mid);
        int[] nums2 = mergeSort(nums, mid +1, right);
        return doMerge(nums1, nums2);
    }

    int[] doMerge(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int p1 = 0, p2 = 0, cur = 0, val = 0;
        int[] res = new int[length1 +length2];
        while (p1 < length1 && p2 < length2) {
            val = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2];
            res[cur++] = val;
        }
        while (p1 < length1) {
            res[cur++] = nums1[p1++];
        }
        while (p2 < length2) {
            res[cur++] = nums2[p2++];
        }
        return res;
    }
}
