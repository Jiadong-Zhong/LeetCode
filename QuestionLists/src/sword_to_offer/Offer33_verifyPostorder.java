package sword_to_offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class Offer33_verifyPostorder {
    public static void main(String[] args) {
        int[] postorder = {1, 6, 3, 2, 5};
        Offer33_verifyPostorder solution = new Offer33_verifyPostorder();

    }

    // 递归
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // right 存放的是根节点
    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        // 循环寻找第一个大于根节点值的索引，该点左边的就是左子树
        int index = left;
        while (postorder[index] < postorder[right]) {
            index++;
        }
        // m是右子树的起点
        int mid = index;
        while (postorder[index] > postorder[right]) {
            index++;
        }
        // 如果最后p != right 说明不是二叉搜索树
        return index == right && recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }


}
