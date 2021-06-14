package test;
/**
 * 
 * @author Marcos Somoza Corral
 * @expediente 21711787
 * @fecha 13-06-2021
 *
 **/
public class AlgoritmoKruskalSomoza<Clave, InfoVertice, Coste> {

    int costeTotal = 0;
    private int vecesSumadas = 0;

    public void PrintSol(Grafo<Clave, InfoVertice, Coste> grafo) {
        Lista<Par<Clave, Clave>> sol = AlgoritmoKruskalAR(grafo);
        for (int i = 1; i < sol.longitud(); i++) {
            System.out.print(
                    "//" + sol.consultar(i).getAtributo().toString() + "-" + sol.consultar(i).getValor().toString());
        }
        System.out.println("");
        System.out.println("Con un coste total de:" + costeTotal);
    }

    public Lista<Par<Clave, Clave>> AlgoritmoKruskalAR(Grafo<Clave, InfoVertice, Coste> grafo) {

        Lista<Par<Clave, Clave>> sol = new Lista<Par<Clave, Clave>>();
        Lista<Par<Clave, Clave>> listaAristas = grafo.listaAristas();

        int vertices = grafo.numVertices();

        while (!listaAristas.esVacia() && sol.longitud() < vertices) {
            Par<Clave, Clave> minArista = GetAristaMin(grafo, listaAristas);
            listaAristas.borrar(listaAristas.buscar(minArista));
            if (IsCycle(grafo, sol, minArista.getAtributo(), minArista.getValor(), grafo.listaVertices()))
                sol.insertar(sol.longitud() + 1, minArista);
        }

        return sol;
    }

    private Par<Clave, Clave> GetAristaMin(Grafo<Clave, InfoVertice, Coste> grafo,
            Lista<Par<Clave, Clave>> listaAristas) {

        Par<Clave, Clave> maxArista = new Par<Clave, Clave>();
        int maxAristaCoste = 2147483647; // el entero mas alto en java
        for (int i = 1; i < listaAristas.longitud(); i++) {
            Par<Clave, Clave> arista = listaAristas.consultar(i);
            int coste = (Integer) grafo.costeArista(arista.getAtributo(), arista.getValor());

            if (coste < maxAristaCoste) {
                maxArista = arista;
                maxAristaCoste = coste;
            }
        }
        if (vecesSumadas < grafo.listaVertices().longitud()-1)
            costeTotal += maxAristaCoste;
        vecesSumadas++;

        return maxArista;
    }

    private boolean IsCycle(Grafo<Clave, InfoVertice, Coste> grafo, Lista<Par<Clave, Clave>> sol, Clave origen,
            Clave destino, Lista<Clave> listaVertices) {
        boolean isCycle = false;
        int contador = 1;
        if (origen.equals(destino))// si el no origen es igual al destino
            isCycle = true;
        else {

            listaVertices.borrar(listaVertices.buscar(origen));
            Lista<Clave> sucesores = grafo.listaSucesores(origen);
            while (contador <= sucesores.longitud() && !isCycle) {
                Clave value = sucesores.consultar(contador);
                if (listaVertices.buscar(value) != 0) {
                    isCycle = IsCycle(grafo, sol, value, destino, listaVertices);
                }
                contador++;
            }
        }

        return isCycle;
    }

    public static void main(String[] args) {
        Grafo<Character, String, Integer> grafo3_3 = new Grafo<Character, String, Integer>();
        grafo3_3.insertarVertice('A', "nodo a");
        grafo3_3.insertarVertice('B', "nodo b");
        grafo3_3.insertarVertice('C', "nodo c");
        grafo3_3.insertarVertice('D', "nodo d");
        grafo3_3.insertarVertice('E', "nodo e");
        grafo3_3.insertarVertice('F', "nodo f");
        grafo3_3.insertarVertice('G', "nodo g");

        grafo3_3.insertarArista('A', 'C', 4);
        grafo3_3.insertarArista('D', 'C', 2);
        grafo3_3.insertarArista('B', 'D', 2);
        grafo3_3.insertarArista('C', 'F', 3);
        grafo3_3.insertarArista('D', 'G', 5);
        grafo3_3.insertarArista('E', 'G', 2);
        grafo3_3.insertarArista('F', 'G', 5);

        grafo3_3.insertarArista('A', 'B', 10);
        grafo3_3.insertarArista('A', 'D', 7);

        grafo3_3.insertarArista('B', 'E', 10);

        AlgoritmoKruskalSomoza<Character, String, Integer> kruskal = new AlgoritmoKruskalSomoza<Character, String, Integer>();
        kruskal.PrintSol(grafo3_3);

    }
}
