package test.TEST_EXAM;

import test.Tree;

public class EsArbolBin {
    public boolean esABB(Tree<Integer> aA) {
        boolean abb = false;

        if (!aA.LeftChild().isEmpty()) {
            if (aA.MainNode() > aA.LeftChild().MainNode()) {
                abb = true;
                esABB(aA.LeftChild());
            } else {
                abb = false;
            }
        }

        if (!aA.RightChild().isEmpty()) {
            if (aA.MainNode() < aA.RightChild().MainNode()) {
                abb = true;
                esABB(aA.RightChild());
            }else {
                return false;
            }
        } 

        return abb;
    }

    public static void main(String[] args) {

        Tree<Integer> s2la = new Tree<Integer>(new Tree<Integer>(), 0, new Tree<Integer>()); // Nivel 3
        Tree<Integer> s2ra = new Tree<Integer>(new Tree<Integer>(), 2, new Tree<Integer>()); // Nivel 3
        Tree<Integer> s2lb = new Tree<Integer>(new Tree<Integer>(), 3, new Tree<Integer>()); // Nivel 3
        Tree<Integer> s2rb = new Tree<Integer>(new Tree<Integer>(), 8, new Tree<Integer>()); // Nivel 3

        Tree<Integer> s1l = new Tree<Integer>(s2la, 1, s2ra);// Nivel 2
        Tree<Integer> s1r = new Tree<Integer>(s2lb, 5, s2rb);// Nivel 2

        Tree<Integer> raiz = new Tree<Integer>(s1l, 3, s1r); // Nivel 1

        EsArbolBin ej2 = new EsArbolBin();
        System.out.print(ej2.esABB(raiz));
    }
}
