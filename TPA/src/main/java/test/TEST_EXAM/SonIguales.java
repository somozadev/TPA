package test.TEST_EXAM;

import test.Grafo;
import test.Lista;
import test.Par;

/**
 * 
 * @author Marcos Somoza Corral
 * @expediente 21711787
 * @fecha 15-06-2021
 */

public class SonIguales<Clave, InfoVertice, Coste> {

    public boolean AreEqual(Grafo<Clave, InfoVertice, Coste> g1, Grafo<Clave, InfoVertice, Coste> g2) {
        boolean equalV = true;
        boolean equalA = true;
        
        Lista<Clave> g1v = g1.listaVertices();
        Lista<Clave> g2v = g2.listaVertices();
        Lista<Par<Clave, Clave>> g1a = g1.listaAristas();
        Lista<Par<Clave, Clave>> g2a = g2.listaAristas();
        // System.out.println(g1v.longitud());
        // System.out.println(g2v.longitud());
        // System.out.println(g1a.longitud());
        // System.out.println(g2a.longitud());
// 
        if (g1v.longitud() != g2v.longitud()) {
            equalV = false;
        }
        if (g1a.longitud() != g2a.longitud()) {
            equalA = false;
        }
        if (equalV && equalA) {
            // vertices working
            for (int i = 1; i <= g1v.longitud(); i++) {
                for (int j = 1; j <= g2v.longitud(); j++) {

                    if (g2v.buscar(g1v.consultar(i)) == 0)
                        equalV = false;
                }
            }
            // aristas working, pero esta feo con el contador y tal 
            int contadorAristasIguales = 0;
            for (int i = 1; i <= g1a.longitud(); i++) {
                boolean igualFinded = false;
                for (int j = 1; j <= g2a.longitud(); j++) {
                    if (!igualFinded) {
                        if (g2a.consultar(j).toString().equals(g1a.consultar(i).toString())) {
                            contadorAristasIguales++;
                            igualFinded=true;
                        }
                    }
                }
            }
            if (contadorAristasIguales == g2a.longitud())
                equalA = true;
        }

        // System.out.println("v " + equalV);
        // System.out.println("a " + equalA);

        return (equalV && equalA);
    }

    public static void main(String[] args) {

        Grafo<Character, String, Integer> grafoPrueba1 = new Grafo<Character, String, Integer>();
        Grafo<Character, String, Integer> grafoPrueba2 = new Grafo<Character, String, Integer>();

        grafoPrueba1.insertarVertice('A', "nodo a");
        grafoPrueba1.insertarVertice('B', "nodo b");
        grafoPrueba1.insertarVertice('C', "nodo c");
        grafoPrueba1.insertarVertice('D', "nodo d");
        grafoPrueba1.insertarVertice('E', "nodo e");
        grafoPrueba1.insertarVertice('F', "nodo f");
        grafoPrueba1.insertarVertice('G', "nodo g");

        grafoPrueba2.insertarVertice('A', "nodo a");
        grafoPrueba2.insertarVertice('B', "nodo b");
        grafoPrueba2.insertarVertice('C', "nodo c");
        grafoPrueba2.insertarVertice('D', "nodo d");
        grafoPrueba2.insertarVertice('E', "nodo e");
        grafoPrueba2.insertarVertice('F', "nodo f");
        grafoPrueba2.insertarVertice('G', "nodo g");

        grafoPrueba1.insertarArista('A', 'C', 4);
        grafoPrueba1.insertarArista('D', 'C', 2);
        grafoPrueba1.insertarArista('B', 'D', 2);
        grafoPrueba1.insertarArista('C', 'F', 3);
        grafoPrueba1.insertarArista('D', 'G', 5);
        grafoPrueba1.insertarArista('E', 'G', 2);
        grafoPrueba1.insertarArista('F', 'G', 5);
        grafoPrueba1.insertarArista('A', 'B', 10);
        grafoPrueba1.insertarArista('A', 'D', 7);
        grafoPrueba1.insertarArista('B', 'E', 10);

        grafoPrueba2.insertarArista('A', 'C', 4);
        grafoPrueba2.insertarArista('D', 'C', 2);
        grafoPrueba2.insertarArista('B', 'D', 2);
        grafoPrueba2.insertarArista('C', 'F', 3);
        grafoPrueba2.insertarArista('D', 'G', 5);
        grafoPrueba2.insertarArista('E', 'G', 2);
        grafoPrueba2.insertarArista('F', 'G', 5);
        grafoPrueba2.insertarArista('A', 'B', 10);
        grafoPrueba2.insertarArista('A', 'D', 7);
        grafoPrueba2.insertarArista('B', 'E', 10);

        SonIguales<Character, String, Integer> iguales = new SonIguales<Character, String, Integer>();
        System.out.println("los dos grafos dados son iguales? : " + iguales.AreEqual(grafoPrueba1, grafoPrueba2));

        // cabe destacar que no se esta comparando el coste , solo si tienen los mismos vertices y las mismas aristas que los conectan
    }   
}
