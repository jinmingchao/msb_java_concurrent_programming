package msb_algorithm.algorithem;

import java.util.LinkedList;
import java.util.List;

public class App_20240408 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> arr = new LinkedList<>();
            boolean[] visited = new boolean[nums.length];
            arr.add(nums[i]);
            visited[i] = true;
            backTrack(res, arr, visited, nums);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
        return res;
    }

    void backTrack(List<List<Integer>> res, List<Integer> arr, boolean[] visited ,int[] nums) {
        if (arr.size() == nums.length) {
            List<Integer> l = new LinkedList<>();
            for(Integer i : arr) {
                l.add(i);
            }
            res.add(l);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            arr.add(nums[i]);
            visited[i] = true;
            backTrack(res, arr, visited, nums);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
    }
}
