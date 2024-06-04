package algorithm.algorithem;

import java.util.*;

/**
 *  lc 74 搜索二维矩阵
 *
 */


public class App_20240423_2 {

    class MyComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public int countComponents(int n, int[][] edges) {
        Arrays.sort(edges, new MyComparator());
        int cnt = 0;
        int remain = n;

        Map<Integer,List<int[]>> nodeMap = new HashMap();
        Map<int[], Integer> indexMap = new HashMap();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(nodeMap.containsKey(edge[0])) {
                nodeMap.get(edge[0]).add(edge);
            } else {
                List<int[]> l = new LinkedList();
                l.add(edge);
                nodeMap.put(edge[0], l);
            }

            indexMap.put(edge, i);
        }

        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (visited[e[0]] && visited[e[1]]) continue;
            cnt++;
            q.offer(edges[i]);
            visited[e[0]] = true;
            visited[e[1]] = true;


            while (!q.isEmpty()) {

                int[] node = q.poll();

                if (null != nodeMap.get(node[0])) {
                    for(int[] tmp :nodeMap.get(node[0])) {
                        if (visited[tmp[0]] && visited[tmp[1]]) continue;
                        q.offer(tmp);
                        visited[tmp[0]] = true;
                        visited[tmp[1]] = true;
                    }

                }

                if (null != nodeMap.get(node[1])) {
                    for(int[] tmp :nodeMap.get(node[1])) {
                        if (visited[tmp[0]] && visited[tmp[1]]) continue;
                        q.offer(tmp);
                        visited[tmp[0]] = true;
                        visited[tmp[1]] = true;
                    }
                }
            }
        }

        for (boolean v : visited) {
            if(v) {
                remain--;
            }
        }

        return cnt += remain;

    }

}
