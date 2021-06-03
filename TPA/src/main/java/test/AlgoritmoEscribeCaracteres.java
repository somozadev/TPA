package test;

import java.util.ArrayList;

public class AlgoritmoEscribeCaracteres {
    /*
     * EJERCICIO 2 Diseñar (pseudocódigo) e implementar en Java una función que
     * reciba como entrada un árbol binario de letras, y que escriba por pantalla
     * los caracteres almacenados en el último nivel. Utilizar para ello las
     * operaciones del TAD ArbolBin visto en la asignatura y la implementación
     * proporcionada. Pueden codificarse las funciones auxiliares que se deseen.
     * Calcular de manera razonada su eficiencia, justificando las complejidades de
     * las operaciones y funciones utilizadas
     */
    public static void main(String[] args) {

        Tree<Character> s3lg = new Tree<Character>(new Tree<Character>(), 'Ñ', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rg = new Tree<Character>(new Tree<Character>(), 'N', new Tree<Character>()); // Nivel 4
        Tree<Character> s3lf = new Tree<Character>(new Tree<Character>(), 'M', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rf = new Tree<Character>(new Tree<Character>(), 'L', new Tree<Character>()); // Nivel 4
        Tree<Character> s3le = new Tree<Character>(new Tree<Character>(), 'K', new Tree<Character>()); // Nivel 4
        Tree<Character> s3re = new Tree<Character>(new Tree<Character>(), 'J', new Tree<Character>()); // Nivel 4
        Tree<Character> s3ld = new Tree<Character>(new Tree<Character>(), 'I', new Tree<Character>()); // Nivel 4
        Tree<Character> s3rd = new Tree<Character>(new Tree<Character>(), 'H', new Tree<Character>()); // Nivel 4

        Tree<Character> s2la = new Tree<Character>(s3lg, 'G', s3rg); // Nivel 3
        Tree<Character> s2ra = new Tree<Character>(s3lf, 'F', s3rf); // Nivel 3
        Tree<Character> s2lb = new Tree<Character>(s3le, 'E', s3re); // Nivel 3
        Tree<Character> s2rb = new Tree<Character>(s3ld, 'D', s3rd); // Nivel 3

        Tree<Character> s1l = new Tree<Character>(s2la, 'C', s2ra);// Nivel 2
        Tree<Character> s1r = new Tree<Character>(s2lb, 'B', s2rb);// Nivel 2

        Tree<Character> raiz = new Tree<Character>(s1l, 'A', s1r); // Nivel 1

        System.out.println("Elementos en el último nivel: " + raiz.GetElementsInlastLevel());
    }

}
