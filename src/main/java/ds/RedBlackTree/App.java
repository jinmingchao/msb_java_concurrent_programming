package ds.RedBlackTree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  红黑树操作:
 *         // 1. 旋转&变色
 *         // 2. 添加数据 [a.普通的二叉树插入, b.红黑树平衡]
 *         // 3. 删除数据
 *         // 4. 遍历数据
 */
public class App {
    public static void main(String[] args) {
        // 1. 旋转&变色
        RBNode rn = RBNode.buildRnForLeftRotation();
        RBNode h = leftRotate(rn);
        System.out.println();
        // 2. 添加数据 [a.普通的二叉树插入, b.红黑树平衡]
        // 3. 删除数据
        // 4. 遍历数据
    }

    /**
     * 左旋rn
     *
     *
     * @param rn
     */
    public static RBNode leftRotate(RBNode rn) {
        if (rn != null) {
            //一. 如果 rn.right.left不为空, 左旋之后，rn.right.left会成为原先rn的右节点
            RBNode r = rn.right;
            if (null != r && r.left != null) {
               r.left.parent = rn; //左旋之后，rn.right.left会成为原先rn的右节点
            }

            //二. 处理rn父节点与r的关系
            r.parent = rn.parent; //如果rn上面还有点, 则新的rn的parent也要指向它
            if (r.parent == null) {
                r.isRoot = true; //r为根节点
            } else if (rn.parent.left == rn) { // rn是它父节点的左节点
                rn.parent.left = r; //rn.parent指向新的rn位置的点
            } else {
                rn.parent.right = r;
            }
            //三. 设置rn和r的关系
            RBNode l = r.left;
            r.left = rn;
            rn.parent = r;
            rn.right = l;
            return r;
        } else {
            return null;
        }
    }

    public static void rightRotate(RBNode rn) {

    }
}
