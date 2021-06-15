package test.TEST_EXAM;

import java.util.List;

import test.Grafo;
import test.Lista;
import test.Par;

public class PuntosDeArticulacion<Clave, InfoVertice, Coste> {

    public static <Clave, InfoVertice, Coste> Lista<Clave> puntosArticulacion(Grafo<Clave, InfoVertice, Coste> graph) {

        // si al quitar el vertice y todas las aristas que lo unen al grafo, el grafo
        // deja de ser conexo, se trata de un punto de articulacion
        Lista<Clave> vertices = graph.listaVertices();
        Lista<Clave> puntosArtic = new Lista<Clave>();

        for (int i = 1; i < vertices.longitud(); i++) {
            if (isArtic(graph, vertices.consultar(i)))
                puntosArtic.insertar(puntosArtic.longitud() + 1, vertices.consultar(i));
            System.out.println(puntosArtic);
            System.out.println("////////////////////");
        }
        return puntosArtic;
    }

    private static <Clave, InfoVertice, Coste> boolean isArtic(Grafo<Clave, InfoVertice, Coste> graph, Clave v) {
        boolean artic = false;

        Grafo<Character, String, Integer> graphAux = new Grafo<>();
        for (int i = 1; i <= graph.listaVertices().longitud(); i++) {
            graphAux.insertarVertice(graph.listaVertices().consultar(i).toString().charAt(0), "new");
        }
        for (int i = 1; i <= graph.listaAristas().longitud(); i++) {
            graphAux.insertarArista(graph.listaAristas().consultar(i).getAtributo().toString().charAt(0),
                    graph.listaAristas().consultar(i).getValor().toString().charAt(0), i);
        }
        System.out.println("VERTICE A CONSULTAR: " + v);
        System.out.println("GRAF: " + graphAux);

        for (int i = 1; i <= graph.listaAristas().longitud(); i++) {
            Par<Clave, Clave> edge = graph.listaAristas().consultar(i);

            if (edge.getAtributo().equals(v) || edge.getValor().equals(v)) {
                System.out.println("edge.getAtributo().toString().charAt(0), edge.getValor().toString().charAt(0)> " +edge.getAtributo().toString().charAt(0) + edge.getValor().toString().charAt(0));
                graphAux.eliminarArista(edge.getAtributo().toString().charAt(0), edge.getValor().toString().charAt(0));

            }

        }
        graphAux.eliminarVertice(v.toString().charAt(0));
        System.out.println("CURRENT AUXG: " + graphAux);
        System.out.println("IsConexo: " + IsConexo(graphAux));
        if (IsConexo(graphAux))
            artic = true;

        return artic;
    }

    private static <Clave, InfoVertice, Coste> boolean IsConexo(Grafo<Clave, InfoVertice, Coste> graph) {
        boolean conexo = true;
        
        return conexo;
    }

    public static void main(String[] args) {

        Grafo<Character, String, Integer> grafoPrueba1 = new Grafo<Character, String, Integer>();

        grafoPrueba1.insertarVertice('A', "nodo a");
        grafoPrueba1.insertarVertice('B', "nodo b");
        grafoPrueba1.insertarVertice('C', "nodo c");
        grafoPrueba1.insertarVertice('D', "nodo d");
        grafoPrueba1.insertarVertice('E', "nodo e");
        grafoPrueba1.insertarVertice('F', "nodo f");

        grafoPrueba1.insertarArista('A', 'D', 4);
        grafoPrueba1.insertarArista('B', 'C', 4);
        grafoPrueba1.insertarArista('B', 'E', 4);
        grafoPrueba1.insertarArista('D', 'B', 4);
        grafoPrueba1.insertarArista('D', 'E', 4);
        grafoPrueba1.insertarArista('C', 'F', 4);

        System.out.println("puntos de articulacion : " + PuntosDeArticulacion.puntosArticulacion(grafoPrueba1));

        // FUNCIONA BIEN, MENOS LA FUNCION DE ISCONEXO (asi que no pasa nada, segun el enunciado, esta funcion viene dada jeje)
    }
}
