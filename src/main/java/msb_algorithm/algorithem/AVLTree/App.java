package msb_algorithm.algorithem.AVLTree;

public class App {

    public static void main(String[] args) {
        App a = new App();
        //1.
        AVLNode<Integer> root = a.buildInBalanceTree_1();
        AVLNode<Integer> newRoot = a.rightRotate(root);
        //层序打印AVL Tree
    }

    /**
     * AVL树 导致不满足平衡的插入点为 root.left.left
     * 进行右旋操作
     *      不满足平衡的插入点为root.right.right时同理
     * @param k2 失衡节点, 即根节点
     * @return
     */
    public AVLNode rightRotate(AVLNode<Integer> k2) {
        AVLNode<Integer> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k1.height = getHeight(k1);
        k2.height = getHeight(k2);
        System.out.println("k1.height: " + k1.height + ",k2.height: " + k2.height);
        return k1; //返回调整后原失衡节点处节点
    }

    public AVLNode leftRotate(AVLNode<Integer> k2) {
        AVLNode<Integer> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k1.height = getHeight(k1);
        k2.height = getHeight(k2);
        System.out.println("k1.height: " + k1.height + ",k2.height: " + k2.height);
        return k1; //返回调整后原失衡节点处节点
    }

    /**
     * AVL树 导致不满足平衡的插入点为 root.left.right
     * 对root.left.right节点进行先左旋再右旋操作
     * 不满足平衡的插入点为root.right.left时同理, 对root.right.left节点进行先右旋再左旋操作
     * @param k2
     * @return
     */
    public AVLNode leftThenRightRotate(AVLNode<Integer> k2) {
        return null;
    }



    private int getHeight(AVLNode node) {
        if (null == node) return 0;
        if (node.left == null && node.right == null) return 1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private AVLNode buildInBalanceTree_1() {
        AVLNode<Integer> root = new AVLNode<>(1, 4);
        root.left = new AVLNode(2, 3);
        root.right = new AVLNode(3, 3);
        root.left.left = new AVLNode(4, 2);
        root.left.right = new AVLNode(5, 1);
        root.left.left.left = new AVLNode(6, 1);
        return root;
    }
}
