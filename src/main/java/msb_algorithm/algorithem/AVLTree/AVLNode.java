package msb_algorithm.algorithem.AVLTree;

public class AVLNode<E> {
    public E val;
    public int height = 1; //高度
    public AVLNode left;
    public AVLNode right;

    public AVLNode(E val) {
        this.val = val;
    }

    public AVLNode(E val, int height) {
        this.val = val;
        this.height = height;
    }
}
