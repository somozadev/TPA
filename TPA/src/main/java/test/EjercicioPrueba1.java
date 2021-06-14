package test;


/**
 * 
 * @author Marcos Somoza Corral
 * @expediente 21711787
 * @fecha 13-06-2021
 *
 **/
public class EjercicioPrueba1 {

    public double GetFactorDeCarga(Tree<Character> tree) {
        int depth = tree.GetTreeDepth();
        double maxNodes = Math.pow(2, depth) - 1;
        
        double chargeFactor = CountEmptyNodes(tree, 0) / maxNodes;
        return chargeFactor;
    }

    private int CountEmptyNodes(Tree<Character> tree, int contador) {
        if (tree.isEmpty())
            return contador;
        if (tree.MainNode().equals(' ')) {
            contador++;
        }
        contador = CountEmptyNodes(tree.LeftChild(), contador);
        contador = CountEmptyNodes(tree.RightChild(), contador);
        return contador;
    }

    public static void main(String[] args) {

        Tree<Character> s3lg = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rg = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3lf = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rf = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3le = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3re = new Tree<Character>(new Tree<Character>(), 'F', new Tree<Character>()); // Nivel 4
        Tree<Character> s3ld = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rd = new Tree<Character>(new Tree<Character>(), ' ', new Tree<Character>()); // Nivel 4

        Tree<Character> s2la = new Tree<Character>(s3lg, ' ', s3rg); // Nivel 3
        Tree<Character> s2ra = new Tree<Character>(s3lf, ' ', s3rf); // Nivel 3
        Tree<Character> s2lb = new Tree<Character>(s3le, 'D', s3re); // Nivel 3
        Tree<Character> s2rb = new Tree<Character>(s3ld, 'E', s3rd); // Nivel 3

        Tree<Character> s1l = new Tree<Character>(s2la, 'C', s2ra);// Nivel 2
        Tree<Character> s1r = new Tree<Character>(s2lb, 'B', s2rb);// Nivel 2

        Tree<Character> raiz = new Tree<Character>(s1l, 'A', s1r); // Nivel 1
        EjercicioPrueba1 ej = new EjercicioPrueba1();
        System.out.println("El factor de carga es: " + ej.GetFactorDeCarga(raiz));

    }
}