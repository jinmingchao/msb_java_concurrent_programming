package ds.RedBlackTree;

public class RBNode<K extends Comparable<K>, V> {

    static Builder builder(){
        return new Builder();
    }

    private K key;
    private V value;

    public RBNode parent; //父
    public RBNode left;
    public RBNode right;

    /**
     *  当前节点的深度
     */
    public int depth;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     *  节点是否为根节点
     */
    public boolean isRoot = false;

    /**
     *  节点颜色
     */
    public boolean color;

    static class Builder<K extends Comparable<K>, V>{
        RBNode node = new RBNode<K,V>();
        Builder key(K key){
            node.key = key;
            return this;
        }

        Builder value(V value){
            node.value = value;
            return this;
        }

        Builder parent(RBNode parent){
            node.parent = parent;
            return this;
        }

        Builder left(RBNode left){
            node.left = left;
            return this;
        }

        Builder right(RBNode right){
            node.right = right;
            return this;
        }

        Builder depth(int depth){
            node.depth = depth;
            return this;
        }

        RBNode build(){
            return node;
        }

    }

    /**
     * 生成一颗bst如下图
     *           rn
     *         /   \
     *        a     b
     *       / \
     *     c   d
     *    /
     *   e
     * @return rn节点
     */
    static public RBNode buildRnForRightRotation(){

        RBNode rn = RBNode.builder().depth(1).key("rn").build();
        RBNode a = RBNode.builder().depth(2).key("a").build();
        RBNode b = RBNode.builder().depth(2).key("b").build();
        RBNode c = RBNode.builder().depth(3).key("c").build();
        RBNode d = RBNode.builder().depth(3).key("d").build();
        RBNode e = RBNode.builder().depth(4).key("e").build();

        rn.left = a;
        rn.right = b;
        a.left = c;
        a.right = d;
        c.left = e;
        return rn;
    }

    /**
     * 生成一颗bst如下图
     *           rn
     *         /   \
     *        a     b
     *             / \
     *            c   d
     *           /
     *         e
     * @return rn节点
     */
    static public RBNode buildRnForLeftRotation(){

        RBNode rn = RBNode.builder().depth(1).key("rn").build();
        RBNode a = RBNode.builder().depth(2).key("a").build();
        RBNode b = RBNode.builder().depth(2).key("b").build();
        RBNode c = RBNode.builder().depth(3).key("c").build();
        RBNode d = RBNode.builder().depth(3).key("d").build();
        RBNode e = RBNode.builder().depth(4).key("e").build();

        rn.left = a;
        rn.right = b;
        b.left = c;
        b.right = d;
        c.left = e;
        return rn;
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
