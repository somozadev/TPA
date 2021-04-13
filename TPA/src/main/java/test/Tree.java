package test;

public class Tree<T> {

    class Node {
        T info;
        Node leftChild;
        Node rightChild;

        Node(Node leftChild, Node rightChild, T info) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.info = info;
        }
    }

    private Node mainNode;

    public Tree() {
        mainNode = null;
    }

    public Tree(Tree<T> subLeft, Tree<T> subRight, T infoMainNode) {
        Node left = subLeft == null ? null : subLeft.mainNode;
        Node right = subRight == null ? null : subRight.mainNode;

        this.mainNode = new Node(left, right, infoMainNode);
    }

    public boolean isEmpty() {
        return mainNode == null;
    }


    public Tree<T> LeftChild()
    {
        Tree<T> subLeft = new Tree<T>();
        subLeft.mainNode = this.mainNode.leftChild;
        return subLeft;
    }public Tree<T> RightChild()
    {
        Tree<T> subRight = new Tree<T>();
        subRight.mainNode = this.mainNode.rightChild;
        return subRight;
    }
    public T MainNode()
    {
        return this.mainNode.info;
    }
}
