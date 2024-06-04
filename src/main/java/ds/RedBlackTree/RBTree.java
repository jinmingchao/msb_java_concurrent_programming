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
        RBNode<K,V> addedNode = RBNode.builder().key(key).value(value).parent(_parent).build();
        // 判断addedNode是_parent的左节点还有右节点
        if (i < 0) {
            _parent.left = addedNode;
        } else if(i > 0) {
            _parent.right = addedNode;
        }
        //二. 调整平衡, 旋转, 变色

    }
}
