package test.TEST_EXAM;

import test.Grafo;
import test.Lista;

public class NoConectados<Clave, InfoVertice, Coste> {

    public static <Clave, InfoVertice, Coste> Lista<Clave> NonConnected(Grafo<Clave, InfoVertice, Coste> gr, Clave inicio) {
        Lista<Clave> listaNoConnected = new Lista<Clave>();
        Lista<Clave> noVisitados = gr.listaVertices();
        Grafo.profREC(gr, inicio, noVisitados);
        while (noVisitados.esVacia() == false) {
            System.out.println("\n**Nueva componente conexa**\n");
            System.out.println(noVisitados.consultar(1));
            for (int i = 1; i <= noVisitados.longitud(); i++) {
                listaNoConnected.insertar(listaNoConnected.longitud() + 1, noVisitados.consultar(i));
                noVisitados.borrar(1);
            }
        }

        return listaNoConnected;
    }

    public static void main(String[] args) {

        Grafo<Character, String, Integer> grafoPrueba1 = new Grafo<Character, String, Integer>();

        grafoPrueba1.insertarVertice('A', "nodo a");
        grafoPrueba1.insertarVertice('B', "nodo b");
        grafoPrueba1.insertarVertice('C', "nodo c");
        grafoPrueba1.insertarVertice('D', "nodo d");
        grafoPrueba1.insertarVertice('E', "nodo e");
        grafoPrueba1.insertarVertice('F', "nodo f");
        grafoPrueba1.insertarVertice('G', "nodo g");

        grafoPrueba1.insertarArista('A', 'C', 4);
        grafoPrueba1.insertarArista('D', 'C', 2);
        // grafoPrueba1.insertarArista('B', 'D', 2);
        grafoPrueba1.insertarArista('C', 'F', 3);
        grafoPrueba1.insertarArista('D', 'G', 5);
        grafoPrueba1.insertarArista('E', 'G', 2);
        grafoPrueba1.insertarArista('F', 'G', 5);
        grafoPrueba1.insertarArista('A', 'B', 10);
        grafoPrueba1.insertarArista('A', 'D', 7);
        //grafoPrueba1.insertarArista('B', 'E', 10);

        System.out.println("listaNoConectados : " + NoConectados.NonConnected(grafoPrueba1, grafoPrueba1.listaVertices().consultar(1)));
    }

}
