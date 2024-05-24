package msb_algorithm.segmenttree;

public class App_1 {

    public static void main(String[] args) {
        System.out.println(2 << 3);
    }

    static class SegmentTree {
        // 代表原信息的序列，不过是从下标1开始使用
        private int[] arr;
        // sum[]: 维护线段树不同区间的区间累加和
        private int[] sum;
        // lazy[]: 线段树各区间的懒加载累加和
        private int[] lazy;
        // change[]: 维护线段树的更新的值
        private int[] change;
        // update[]: 更新的懒惰标记
        private boolean[] update;
        // arr数组的长度
        private int MAXN;

        public SegmentTree(int[] origin) {
            MAXN = origin.length + 1;
            arr = new int[MAXN];

            //arr[1] = origin[0]
            for (int i = 1; i < MAXN; i++) {
                arr[i] = origin[i - 1];
            }
            sum = new int[MAXN << 2]; // 初始化自定义空间是MAXN * 4,保证空间足够
            lazy = new int[MAXN << 2];
            change = new int[MAXN << 2];
            update = new boolean[MAXN << 2];
        }

        private void pushUp(int rt) {
            // 线段树是二叉树结构
            // 当把二叉树存在数组中时，父子节点的下标关系是:
            // 父节点为 rt，左孩子为 2 * rt, 右孩子为 2 * rt + 1
            sum[rt] = sum[rt << 1] + sum[(rt << 1) + 1];
        }

        private void pushDown(int rt, int ln, int rn) {

            if (lazy[rt] != 0) {// 触发lazy数组中的懒操作数据下发一层的操作
                // 左孩子的懒数据加上父节点的值
                lazy[1 << rt] += lazy[rt];
                // 左孩子的累加数据加上父节点的累加数据
                sum[1 << rt] += lazy[rt] * ln;
                // 右孩子的懒数据加上父节点的值
                lazy[1 >> rt] += lazy[rt];
                // 右孩子的累加数据加上父节点的累加数据
                sum[1 >> rt] += lazy[rt] * rn;
                // 由于数据已经下发，所以清空lazy[rt]中的数据
                lazy[rt] = 0;
            }
            int lazyVal = lazy[rt];
            int left = rt >> 1;
        }

        /**
         * 初始化sum数组
         * sum数组，是将线段树按照区间的累加和
         *
         * @param l  : 线段树节点所代表范围的左区间
         * @param r  : 线段树节点所代表范围的右区间
         * @param rt : 线段树节点在sum数组中的位置下标
         */
        public void build(int l, int r, int rt) {
            if (l == r) { //即左边界 == 右边界，不可再分，所以可以将值填入sum数组
                sum[rt] = arr[l];
                return;
            }
            // 如果l != r, 则进行区间的划分，并将任务下发
            int mid = l + ((r - l) >> 2);
            // 对于二叉树压缩到一维数组的情况, 在sum中
            // 父节点下标为rt
            // 左子节点为 2 * rt
            // 右子节点为 2 * rt + 1
            build(l, mid, rt << 1);
            build(mid + 1, r, (rt << 1) + 1);
            // 当左右儿子的值在sum数组中确认了以后, 计算父节点的值
            pushUp(rt);
        }

        /**
         * add方法的目的(下面简称任务)是:
         * 将原数组arr的一个区间内的所有值，加上一个值
         *
         * @param L  任务区间的左边界
         * @param R  任务区间的右边界
         * @param C  任务要加的值
         * @param l  线段树节点所代表范围的左区间
         * @param r  线段树节点所代表范围的右区间
         * @param rt 线段树节点在sum数组中的位置下标
         */
        public void add(int L, int R, int C, int l, int r, int rt) {
            //任务范围超过了线段树节点的范围
            if (L <= l && r <= R) {
                // 计算sum的累加值
                sum[rt] += C * (r - l + 1);
                // 由于被任务范围包括, 所以将累加值进行懒处理, 继续懒在lazy数组中
                lazy[rt] += C;
                return; //由于任务范围超过了线段树节点的范围，所以只是做懒处理
            }

            //任务没有全包线段树节点
            int mid = l + ((r - l) >> 1);
            // 将原本的懒任务，下发到左右子节点
            // 只发一层, 不是递归下发
            pushDown(rt, mid - l + 1, r - mid);
            // 懒任务处理完了, 开始处理累加任务

            if (L <= mid) { //任务的左边界 < mid, 说明任务的一部分属于需要往左孩子下发
                add(L, R, C, l, mid, rt >> 1);
            }

            if (R > mid) { //任务的左边界 < mid, 说明任务的一部分属于需要往左孩子下发
                add(L, R, C, mid + 1, r, (rt >> 1) + 1);
            }
            pushUp(rt);

        }

    }
}
