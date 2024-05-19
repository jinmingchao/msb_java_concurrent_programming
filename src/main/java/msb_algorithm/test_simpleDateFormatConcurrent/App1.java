package msb_algorithm.test_simpleDateFormatConcurrent;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class App1 {
    static class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
        System.out.println();

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> fullPathMap = new HashMap();
        Set<TreeNode> pfullPathNodes = new HashSet<>();

        fullPathMap.put(root, null);
        getFullPath(root, fullPathMap);

        TreeNode pRoot = p, qRoot = q;
        pfullPathNodes.add(pRoot);
        while (fullPathMap.get(pRoot) != null) {
            pRoot = fullPathMap.get(pRoot);
            pfullPathNodes.add(pRoot);
        }


        while (qRoot != null) {
            if (pfullPathNodes.contains(qRoot)) {
                return qRoot;
            }
            qRoot = fullPathMap.get(qRoot);
        }

        return null;
    }

    void getFullPath(TreeNode cur, Map<TreeNode, TreeNode> m) {

        if (cur == null) return;

        if (cur.left != null) {
            m.put(cur.left, cur);
            getFullPath(cur.left, m);
        }

        if (cur.right != null) {
            m.put(cur.right, cur);
            getFullPath(cur.right, m);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> q = new LinkedList();
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerFirst(new int[]{nums[i], i});
        }

        ans[idx++] = q.peekFirst()[0];

        for (int i = k; i < n; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerFirst(new int[]{nums[i], i});
            ans[idx++] = q.peekFirst()[0];
            while (!q.isEmpty() && q.peekLast()[1] < i - k) {
                q.pollLast();
            }
        }
        return ans;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0, length = nums.length;
        while (right < length) {
            if (nums[right] != nums[val]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }

}
