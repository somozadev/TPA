package test;

public class arbolbin {
    
    public static void test()
    {

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
