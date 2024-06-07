package ds.RedBlackTree;

public class RBTree<K extends Comparable<K>, V> {

    public static RBNode root = null;


    /**
     * 红黑树put方法, 主要步骤:
     * 1.向BST中插入元素
     * 2.调整平衡, 旋转, 变色
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {

        if(key == null) throw new NullPointerException();

        //一. 向BST中插入元素
        RBNode n = this.root;
        // rbt是空的, 插入的节点就是root节点
        if (n == null) {
            n = RBNode.builder().key(key).value(value != null ? value : key).parent(null).build();
            this.root = n;
            // 根节点为black
            this.root.color = RBNode.BLACK;
            return;
        }

        // rbt不是空，开始进行比较并插入操作
        // 需要插入位置的父节点
        RBNode _parent = n;
        int i = 0; //i < 0, key较小; i > 0, key较大

        do  {
            i = key.compareTo((K) n.key);
            if (i < 0) {
                // key < n.key
                // 往左找
                _parent = n;
                n = n.left;

            } else if (i > 0) {
                // key > n.key
                // 往右找
                _parent = n;
                n = n.right;
            } else {
                // key == n.key
                // 1. 覆盖掉原值
                root.value = value == null ? key : value;
                return;
            }

        } while (n != null);
        // 跳出循环了，说明找到了要插入的位置
        // 创建节点
        RBNode<K,V> e = RBNode.builder().key(key).value(value).parent(_parent).build();
        // 判断addedNode是_parent的左节点还有右节点
        if (i < 0) {
            _parent.left = e;
        } else if(i > 0) {
            _parent.right = e;
        }
        //二. 调整平衡, 旋转, 变色
        fixAfterPut(e);

    }

    /**
     * 调整节点平衡
     * 分析各种情况
     *   1.  234树: 在2节点上插入一个节点，插入完成后变成一个3节点
     *       红黑树: 给一个叶子节点(黑节点)(因为是普通的根据BST性质的插入，所以一定插在根上)上插一个节点
     *              不需要进行处理(为啥不变黑？)
     *   2.  234树: 在一个3节点上插入一个节点，插入完成后变成一个4节点，会有三个元素
     *             3节点的结构有6种，其中【根左左，根左右，根右左，根右右】的结构在插入后需要调整, 剩下【左根右】两种结构不需要变化
     *
     * @param e
     */
    private void fixAfterPut(RBNode<K,V> e) {

    }
}
