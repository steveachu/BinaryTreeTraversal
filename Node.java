package binarytree;

public class Node {
    private int mData;
    private Node mLeft, mRight, mParent;
    
    Node(int data) {
        mData = data;
        mLeft = mRight = mParent = null;
    }
    
    Node insert(Node root, int data) {
        Node n = new Node(data);
        if (root == null) {
            return n;
        }
        Node parent = null;
        Node current = root;
        while (current != null) {
            parent = current;
            if (current.mData <= data) {
                current = current.mRight;
            }
            else {
                current = current.mLeft;
            }
        }
        if (parent.mData <= data) {
            parent.mRight = n;
        }
        else {
            parent.mLeft = n;
        }
        return n;
    }
    
    void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.mData + " ");
            preOrderTraversal(root.mLeft);
            preOrderTraversal(root.mRight);
        }
    }
    
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.mLeft);
            System.out.println(root.mData + " ");
            inOrderTraversal(root.mRight);
        }
    }
    
    void postOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.mLeft);
            inOrderTraversal(root.mRight);
            System.out.println(root.mData + " ");            
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(root, -5);
        root.insert(root, 16);
        root.insert(root, -8);
        root.insert(root, 7);
        root.insert(root, 18);

        root.inOrderTraversal(root);
        root.preOrderTraversal(root);
        root.postOrderTraversal(root);
    }
}
