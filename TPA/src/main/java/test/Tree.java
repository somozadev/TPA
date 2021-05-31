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

    public Tree(Tree<T> subLeft, T infoMainNode, Tree<T> subRight) {
        Node left = subLeft == null ? null : subLeft.mainNode;
        Node right = subRight == null ? null : subRight.mainNode;

        this.mainNode = new Node(left, right, infoMainNode);
    }

    public boolean isEmpty() {
        return mainNode == null;
    }

    public Tree<T> LeftChild() {
        Tree<T> subLeft = new Tree<T>();
        subLeft.mainNode = this.mainNode.leftChild;
        return subLeft;
    }

    public Tree<T> RightChild() {
        Tree<T> subRight = new Tree<T>();
        subRight.mainNode = this.mainNode.rightChild;
        return subRight;
    }

    public T MainNode() {
        return this.mainNode.info;
    }



    /* CUSTOM METHODS */

    public int GetTreeDepth() {
        if (this.isEmpty())
            return 0;
        else
            return 1 + Math.max(this.LeftChild().GetTreeDepth(), this.RightChild().GetTreeDepth());
    }

    public int GetTreeLeafNodes() {
        if (!this.isEmpty())
            return 0;
        else {
            if (this.LeftChild().isEmpty() && this.RightChild().isEmpty())
                return 1;
            else
                return this.LeftChild().GetTreeLeafNodes() + this.RightChild().GetTreeLeafNodes();
        }
    }

    public static void dibujar_arbol_preorden(Tree<Integer> tree) {
        if (!tree.isEmpty()) {
            dibujar_arbol_preorden(tree.LeftChild());
            dibujar_arbol_preorden(tree.RightChild());
            System.out.println(tree.MainNode());
        }
    }

    public static void dibujar_arbol_postorden(Tree<Integer> tree) {
        if (!tree.isEmpty()) {
            dibujar_arbol_preorden(tree.LeftChild());
            dibujar_arbol_preorden(tree.RightChild());
            System.out.println(tree.MainNode());
        }
    }

    public boolean FindABB(Tree<Integer> tree, int data)
    {
        if(!tree.isEmpty())
        {
            System.err.println("*");
            if(data == tree.MainNode())
                return true;
            
            else
            {
                if ( data < tree.MainNode())
                    return FindABB(tree.LeftChild(), data);
                
                else
                    return FindABB(tree.RightChild(), data);

            }
        }
        else
            return false;

    }

    public static void main(String[] args)
    {
        Tree<Integer> s2la = new Tree<Integer>(new Tree<Integer>(),4,new Tree<Integer>());
        Tree<Integer> s2ra = new Tree<Integer>(new Tree<Integer>(),6,new Tree<Integer>());
        Tree<Integer> s2lb = new Tree<Integer>(new Tree<Integer>(),16,new Tree<Integer>());
        Tree<Integer> s2rb = new Tree<Integer>(new Tree<Integer>(),22,new Tree<Integer>());

        Tree<Integer> s1l = new Tree<Integer>(s2la,8,s2ra);
        Tree<Integer> s1r = new Tree<Integer>(s2lb,12,s2rb);
        Tree<Integer> raiz = new Tree<Integer>(s1l,10,s1r);
        
        System.out.println("El N de nodos Hoja: " + raiz.GetTreeDepth());
    }

}
