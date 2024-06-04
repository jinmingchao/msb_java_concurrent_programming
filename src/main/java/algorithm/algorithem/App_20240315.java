package algorithm.algorithem;

/**
 * 二叉树中的 路径 被定义为一条节点序列，
 * <p>
 * 序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * <p>
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0]) {
            return o1[0] - o2[0];
        } else {
            return o1[1] - o2[1];
        }
    }
}

public class App_20240315 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new MyComparator());
        List<int[]> l = new LinkedList<>();
        int n = intervals.length, left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > right) {
                int[] tmp = new int[2];
                tmp[0] = left;
                tmp[1] = right;
                l.add(tmp);
                left = intervals[i][0];
                right = Math.max(intervals[i][1], right);
            } else {
                right = Math.max(intervals[i][1], right);
            }
        }
        int[] tmp = new int[2];
        tmp[0] = left;
        tmp[1] = right;
        l.add(tmp);
        int[][] res= new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;

    }
}


