package test;


public class AlgoritmoPrimSomoza<Clave, Info, Coste> {

    public int Prim(Grafo<Clave, Info, Coste> grafo, Clave a) {

        Lista<Clave> listaDeNodosN = grafo.listaVertices();
        Lista<Par<Clave, Clave>> listaDeAristasT = new Lista<Par<Clave, Clave>>();
        Lista<Clave> listaDeNodosS = new Lista<Clave>();
        int sol = 0;
        Lista<Par<Clave, Clave>> listaDeAristasRestoTemp = new Lista<Par<Clave, Clave>>();

        return AlgoritmoPrimAR(grafo, a, sol, listaDeNodosN, listaDeNodosS, listaDeAristasT, listaDeAristasRestoTemp);
    }

    //Suma el coste total de la lista de aristas pasada por parámetro
    public int GetTotalCost(Grafo<Clave, Info, Coste> grafo, Lista<Par<Clave, Clave>> aristas) {
        int minCoste = 0;
        for (int i = 1; i <= aristas.longitud(); i++)
            minCoste += (int) grafo.costeArista(aristas.consultar(i).getAtributo(), aristas.consultar(i).getValor());

        return minCoste;

    }

    // Devuelve la arista minima de una lista de aristas dada
    public Par<Clave, Clave> AristaMinima(Grafo<Clave, Info, Coste> grafo, Lista<Par<Clave, Clave>> aristas,
            int sumMax) {
        int minCoste = 0;
        Par<Clave, Clave> minArista = new Par<Clave, Clave>();
        for (int i = 1; i <= aristas.longitud(); i++) {
            int auxCoste = (int) grafo.costeArista(aristas.consultar(i).getAtributo(), aristas.consultar(i).getValor());
            if (i == 1 || auxCoste < minCoste) {
                minCoste = auxCoste;
                minArista = aristas.consultar(i);
            }
        }
        aristas.borrar(aristas.buscar(minArista));
        return minArista;
    }

    //Guarda el registro de las aristas no seleccionadas para la proxima selección
    public Lista<Par<Clave, Clave>> GetTempAristas(Lista<Par<Clave, Clave>> aristas,
            Lista<Par<Clave, Clave>> listaDeAristasRestoTemp) {
        for (int i = 1; i <= aristas.longitud(); i++) {
            
            if (listaDeAristasRestoTemp.buscar(aristas.consultar(i)) == 0) {
                listaDeAristasRestoTemp.insertar(1, aristas.consultar(i));
            }
        }
        return listaDeAristasRestoTemp;

    }

    // Devuelve todas las aristas donde el nodo dado se encuentre, ya sea como
    // origen o como destino. Pero resta todas aquellas aristas existentes en los
    // nodos visitados
    public void AristasDelNodo(Grafo<Clave, Info, Coste> grafo, Clave nodo,
            Lista<Clave> nodosVisitados, Lista<Par<Clave, Clave>> listaDeAristasRestoTemp) {
        Lista<Par<Clave, Clave>> aristas = grafo.listaAristas();

        Lista<Par<Clave, Clave>> aristasDelNodo = new Lista<Par<Clave, Clave>>();
        for (int i = 1; i <= aristas.longitud(); i++) {

            if (aristas.consultar(i).getAtributo().equals(nodo) || aristas.consultar(i).getValor().equals(nodo)) {
                if (nodosVisitados.longitud() <= 0)
                    aristasDelNodo.insertar(1, aristas.consultar(i));
                else {
                    boolean shouldInsert = true;
                    for (int j = 1; j <= nodosVisitados.longitud(); j++) {
                        if (aristas.consultar(i).getAtributo().equals(nodosVisitados.consultar(j))
                                || aristas.consultar(i).getValor().equals(nodosVisitados.consultar(j)))
                            shouldInsert = false;
                    }

                    if (shouldInsert)
                        aristasDelNodo.insertar(1, aristas.consultar(i));
                }
            }

        }
        GetTempAristas(aristasDelNodo, listaDeAristasRestoTemp);
    }

    public int AlgoritmoPrimAR(Grafo<Clave, Info, Coste> grafo, Clave a, int costeTotal, Lista<Clave> listaDeNodosN,
            Lista<Clave> listaDeNodosS, Lista<Par<Clave, Clave>> listaDeAristasT,
            Lista<Par<Clave, Clave>> listaDeAristasRestoTemp) {

        AristasDelNodo(grafo, a, listaDeNodosS, listaDeAristasRestoTemp);
        Par<Clave, Clave> aristaMinima = AristaMinima(grafo, listaDeAristasRestoTemp, costeTotal);
        
        listaDeAristasT.insertar(1, aristaMinima);
        listaDeNodosS.insertar(listaDeNodosS.longitud() + 1, a);
        listaDeNodosN.borrar(listaDeNodosN.buscar(a));
        
        if (a == aristaMinima.getValor())
            a = aristaMinima.getAtributo();
        else
            a = aristaMinima.getValor();

        if (listaDeNodosN.longitud() > 1) {
            return AlgoritmoPrimAR(grafo, a, costeTotal, listaDeNodosN, listaDeNodosS, listaDeAristasT,
                    listaDeAristasRestoTemp);
        } else {
            System.out.println("lista de aristas seleccionadas: " + listaDeAristasT);
            return GetTotalCost(grafo, listaDeAristasT);
        }

    }

    public static void main(String[] args) {

        // declara e inicializa un grafo con los datos de los apuntes
        // invoca a la funci�n algoritmoPrimAR, para el grafo anterior, partiendo del
        // v�rtice con clave "A"
        // muestra por pantalla el coste del �rbol de recubrimiento m�nimo generado
        // muestra por pantalla la lista de pares que forman el �rbol

        Grafo<String, String, Integer> grafoPrim = new Grafo<String, String, Integer>();
        grafoPrim.insertarVertice("A", "a");
        grafoPrim.insertarVertice("B", "b");
        grafoPrim.insertarVertice("C", "c");
        grafoPrim.insertarVertice("D", "d");
        grafoPrim.insertarVertice("E", "e");
        grafoPrim.insertarVertice("F", "f");
        grafoPrim.insertarVertice("G", "g");

        grafoPrim.insertarArista("A", "B", 10);
        grafoPrim.insertarArista("A", "D", 7);
        grafoPrim.insertarArista("A", "C", 4);

        grafoPrim.insertarArista("B", "E", 10);

        grafoPrim.insertarArista("C", "D", 2);
        grafoPrim.insertarArista("C", "F", 3);

        grafoPrim.insertarArista("D", "G", 5);
        grafoPrim.insertarArista("D", "B", 2);

        grafoPrim.insertarArista("E", "G", 2);

        grafoPrim.insertarArista("G", "F", 5);

        AlgoritmoPrimSomoza<String, String, Integer> prim = new AlgoritmoPrimSomoza<String, String, Integer>();

        System.out.println("El coste mínimo es: " + prim.Prim(grafoPrim, "A"));

        /* ****** DATOS PERSONALES ****** */

        String miNombre = "Marcos";
        String misApellidos = "Somoza Corral";
        String miExpediente = "21711787";

        System.out.println("\nESTUDIANTE:");
        System.out.println(" * Apellidos:\t" + misApellidos);
        System.out.println(" * Nombre:\t" + miNombre);
        System.out.println(" * Expediente:\t" + miExpediente);

        System.out.println("\n*** FIN ***");

    }
}
