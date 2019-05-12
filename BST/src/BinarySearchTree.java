public class BinarySearchTree {

    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int x){
            this.value = x;
            this.left = null;
            this.right = null;
        }
    }

    private Node search(int x, Node n){
        if(n == null || n.value == x){
            return n;
        }
        if(x < n.value){
            return search(x, n.left);
        }else {
            return search(x, n.right);
        }
    }

    public Node search(int x){
        return search(x, root);
    }

    private Node insert(int x, Node n){
        if(n == null){
            n = new Node(x);
            return n;
        }else if(x < n.value){
            n.left = insert(x, n.left);
        }else if(x > n.value){
            n.right = insert(x, n.right);
        }
        return n;
    }

    public void insert(int x){
        insert(x, root);
    }

//    public int delete(int x){
//
//    }
//
    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(5);
        bst.insert(4);
        bst.insert(9);
        bst.insert(23);

        BSTUtility util = new BSTUtility();
        System.out.println(util.isBST(bst));


    }


}
