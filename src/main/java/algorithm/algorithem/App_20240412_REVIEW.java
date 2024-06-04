package algorithm.algorithem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class App_20240412_REVIEW {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for(int n : nums) pq.offer(n);
        int res = 0;
        while (k > 0) {
            res = pq.poll();
            k--;
        }
        return res;
    }
}
