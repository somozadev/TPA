package test;

import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

public class Ejercicio_arboles {
    
    public static int contarHoja(Tree<Integer> tree)
    {
        if(!tree.isEmpty())
        {            
            if(tree.LeftChild().isEmpty() && tree.RightChild().isEmpty())
                return 1;
            else
            return contarHoja(tree.LeftChild()) + contarHoja(tree.RightChild());
        }
        else
            return 0;
    }

    public static void main(String[] args)
    {
        Tree<Integer> c = new Tree<Integer>(new Tree<Integer>(),6,new Tree<Integer>());

        Tree<Integer> a = new Tree<Integer>(new Tree<Integer>(),1,new Tree<Integer>());
        Tree<Integer> b = new Tree<Integer>(new Tree<Integer>(),10,new Tree<Integer>());
        Tree<Integer> e = new Tree<Integer>(new Tree<Integer>(),4,c);
        
        Tree<Integer> d = new Tree<Integer>(a,2,b);
        Tree<Integer> f = new Tree<Integer>(e,5,new Tree<Integer>());
        Tree<Integer> g = new Tree<Integer>(d,5,f);
        // System.out.println("Suma total de nodos: " + );
        System.out.println("El N de nodos Hoja: " + contarHoja(g));
        
    }
}
