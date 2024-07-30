public class Tree {
  
    private static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node =" + value;
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;

        while(true){
            if(value < current.value){
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){

        var current = root;
        while(current != null){
            if(current.value < value)
                current = current.leftChild;
            else if(current.value > value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
        System.out.println();
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
        System.out.println();
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value + " ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
        System.out.println();
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value + " ");
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int height(){
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min(){
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        int leftValue = 0;
        if(root.leftChild != null)
            leftValue = min(root.leftChild);

        int rightValue = 0;
        if (root.rightChild != null)
            rightValue = min(root.rightChild);

        return Math.min(Math.min(leftValue, rightValue), root.value);
    }

    public boolean equals(Tree other){
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }
    
}
