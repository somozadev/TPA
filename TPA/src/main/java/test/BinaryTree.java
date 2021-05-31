package test;

public class BinaryTree {
    public static void main(String[] args)
    {
        Tree<Integer> s2la = new Tree<Integer>(new Tree<Integer>(),4,new Tree<Integer>());
        Tree<Integer> s2ra = new Tree<Integer>(new Tree<Integer>(),6,new Tree<Integer>());
        Tree<Integer> s2lb = new Tree<Integer>(new Tree<Integer>(),16,new Tree<Integer>());
        Tree<Integer> s2rb = new Tree<Integer>(new Tree<Integer>(),22,new Tree<Integer>());

        Tree<Integer> s1l = new Tree<Integer>(s2la,8,s2ra);
        Tree<Integer> s1r = new Tree<Integer>(s2lb,12,s2rb);
        Tree<Integer> raiz = new Tree<Integer>(s1l,10,s1r);
        int data = 1-4;
        System.out.println("El dato " + data + " esta en el arbol: " + raiz.FindABB(raiz, data));

        Tree<Integer> veinte = new Tree<Integer>(new Tree<Integer>(null,15,null),20,new Tree<Integer>(null,25,null));
        Tree<Integer> diez = new Tree<Integer>( new Tree<Integer>(null,5,null),10,veinte);

        



    }
}


/*dado el siguiente arbol avl 10,5(),20(15,25), instar el 45, 
justificar que lado se desequilibra y
 aplicar las rotaciones necesarias para solucionarlo,
  explicando cada paso de manera independiente.*/