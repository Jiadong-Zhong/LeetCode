
/**
 * 558. 四叉树交集
 * https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 */
public class Intersect {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) { // 如果A是叶子节点
            if (quadTree1.val) { // 如果A的值为true直接返回A
                return quadTree1;
            } else {
                return quadTree2; // A为叶子节点但是A的值为false，返回B
            }
        }

        if (quadTree2.isLeaf) { // 如果B是叶子节点
            if (quadTree2.val) { // 如果B的值为true返回B
                return quadTree2;
            } else {
                return quadTree1; // B为叶子节点，但是B的值为false，返回A
            }
        }

        // A和B都不是叶子节点，递归获取四个方向的子节点
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // 如果4个节点同时为叶子节点，并且值为true，返回节点进行合并，合并为一个值为true的叶子节点
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
            return new Node(true, true, null, null, null, null);
        }

        // 通过获得的4个方位的节点，构造出一个新的树
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
