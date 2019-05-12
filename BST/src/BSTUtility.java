public class BSTUtility {

    private boolean isBSTHelper(BinarySearchTree.Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.value < min || root.value > max){
            return false;
        }
        return isBSTHelper(root.left, min, root.left.value) && isBSTHelper(root.right, root.right.value, max);
    }

    public boolean isBST(BinarySearchTree bst){
        return isBSTHelper(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
