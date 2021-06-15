package test;

/*
 * ArbolBin<Integer> miArbol = new ArbolBin<Integer>(); // creamos arbol binario vacio de n�meros enteros
 * 
 * Integer, Boolean, Float, Character
 */

public class BinaryTree<T> {
    class NodoBin {
        T info;
        NodoBin hijoIzq;
        NodoBin hijoDcho;

        NodoBin(NodoBin hIzq, T info, NodoBin hDcho) {
            this.hijoIzq = hIzq;
            this.hijoDcho = hDcho;
            this.info = info;
        }
    }

    private NodoBin raiz;

    public NodoBin getRaiz() {
        return raiz;
    }

    public BinaryTree() {
        raiz = null;
    }

    public BinaryTree(BinaryTree<T> subIzq, T infoRaiz, BinaryTree<T> subDcho) {

        NodoBin izq = subIzq == null ? null : subIzq.raiz;
        NodoBin dcho = subDcho == null ? null : subDcho.raiz;
        this.raiz = new NodoBin(izq, infoRaiz, dcho);
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public BinaryTree<T> hijoIzquierdo() {
        BinaryTree<T> subIzq = new BinaryTree<T>();
        subIzq.raiz = this.raiz.hijoIzq;

        return subIzq;
    }

    public T raiz() {
        return this.raiz.info;
    }

    public BinaryTree<T> hijoDerecho() {
        BinaryTree<T> subDcho = new BinaryTree<T>();
        subDcho.raiz = this.raiz.hijoDcho;

        return subDcho;
    }

    /*
     * EJERCICIO DECIR SI DOS ARBOLES SON IGUALES
     */
    public static boolean comparaArbol(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {

        if (aA.raiz() == aB.raiz() && aA.hijoIzquierdo().esVacio() && aA.hijoDerecho().esVacio()
                && aB.hijoIzquierdo().esVacio() && aB.hijoDerecho().esVacio()) {

            return true;
        } else if ((aA.raiz() == aB.raiz()) && ((!aA.hijoIzquierdo().esVacio() && !aB.hijoIzquierdo().esVacio())
                && (!aA.hijoDerecho().esVacio() && !aB.hijoDerecho().esVacio()))) {

            return comparaSubIzq(aA, aB) && comparaSubDer(aA, aB);
        } else {
            return false;
        }
    }

    public static boolean comparaSubIzq(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        if (aA.raiz() == aB.raiz()) {
            return comparaArbol(aA.hijoIzquierdo(), aB.hijoIzquierdo());
        } else {
            return false;
        }
    }

    public static boolean comparaSubDer(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        if (aA.raiz() == aB.raiz()) {
            return comparaArbol(aA.hijoDerecho(), aB.hijoDerecho());
        } else {
            return false;
        }
    }

    /*
     * EJERCICIO DECIR SI DOS ARBOLES SON SIMETRICOS
     */
    public static boolean arbolesSimetricos(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {

        if (aA.raiz() == aB.raiz() && aA.hijoIzquierdo().esVacio() && aA.hijoDerecho().esVacio()
                && aB.hijoIzquierdo().esVacio() && aB.hijoDerecho().esVacio()) {
            return true;
        } else if ((aA.raiz() == aB.raiz()) && (!aA.hijoIzquierdo().esVacio() && !aB.hijoDerecho().esVacio())
                && (!aA.hijoDerecho().esVacio() && !aB.hijoIzquierdo().esVacio())) {
            return comparaSubIzqSim(aA, aB) && comparaSubDerSim(aA, aB);
        } else {
            return false;
        }

    }

    public static boolean comparaSubIzqSim(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        // ArbolBin<Integer> aI = aA.hijoIzquierdo();
        // ArbolBin<Integer> bD = aB.hijoDerecho();

        if (aA.raiz() == aB.raiz()) {
            return arbolesSimetricos(aA.hijoIzquierdo(), aB.hijoDerecho());
        } else {
            return false;
        }
    }

    public static boolean comparaSubDerSim(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        // ArbolBin<Integer> aD = aA.hijoDerecho();
        // ArbolBin<Integer> bI = aB.hijoIzquierdo();

        if (aA.raiz() == aB.raiz()) {
            return arbolesSimetricos(aA.hijoDerecho(), aB.hijoIzquierdo());
        } else {
            return false;
        }
    }

    /*
     * EJERCICIO CUENTA PARES
     */
    public static int recorridoPreOrden(BinaryTree<Integer> aA) {
        int countPares = 0;
        return auxPreOrdenPares(aA, countPares);
    }

    public static int auxPreOrdenPares(BinaryTree<Integer> aA, int countPares) {

        // if(aA.raiz() == null) {
        // return -1;
        // }

        if (aA.raiz() % 2 == 0) {
            countPares++;
        }

        auxPreOrdenPares(aA.hijoIzquierdo(), countPares);
        auxPreOrdenPares(aA.hijoDerecho(), countPares);

        return countPares;
    }

    // public static int nodoPar() {
    //
    // }

    public static int cuentaNodos(BinaryTree<Integer> aA) {
        int contador = 1;

        if (aA.hijoIzquierdo() != null) {
            contador += cuentaNodos(aA.hijoIzquierdo());
        }

        if (aA.hijoDerecho() != null) {
            contador += cuentaNodos(aA.hijoDerecho());
        }

        return contador;
    }

    // public static int contNodos(ArbolBin<Integer> aA) {
    // if(aA.esVacio()) {
    // return 0;
    // } else {
    // return contNodos(aA)
    // }
    // }

    // OK - Ejercicio compara arboles Diego clase. Complejidad N, N operaciones de
    // orden constante, N*1 = N
    public static boolean compArboles(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        if (aA.esVacio() && aB.esVacio()) {
            return true;
        } else {
            if ((aA.esVacio() || aB.esVacio())) {
                return false;
            } else {
                if (aA.raiz() == aB.raiz()) {
                    return compArboles(aA.hijoIzquierdo(), aB.hijoIzquierdo())
                            && compArboles(aA.hijoDerecho(), aB.hijoDerecho());
                } else {
                    return false;
                }
            }
        }
    }

    // OK - Ejercicio arboles simetricos Diego clase. Complejidad N, N operaciones
    // de orden constante, N*1 = N
    public static boolean simArboles(BinaryTree<Integer> aA, BinaryTree<Integer> aB) {
        if (aA.esVacio() && aB.esVacio()) {
            return true;
        } else {
            if ((aA.esVacio() || aB.esVacio())) {
                return false;
            } else {
                if (aA.raiz() == aB.raiz()) {
                    return simArboles(aA.hijoIzquierdo(), aB.hijoDerecho())
                            && compArboles(aA.hijoDerecho(), aB.hijoIzquierdo());
                } else {
                    return false;
                }
            }
        }
    }

    // OK - Contar pares Manu clase - Complejidad N, son N operaciones de orden
    // constante N*1 = N
    public static int contarNPares(BinaryTree<Integer> aA) {
        if (!aA.esVacio()) {
            if (aA.raiz() % 2 == 0) {
                return 1 + contarNPares(aA.hijoIzquierdo()) + contarNPares(aA.hijoDerecho());
            } else {
                return contarNPares(aA.hijoIzquierdo()) + contarNPares(aA.hijoDerecho());
            }
        } else {
            return 0;
        }
    }

    // Decir si un arbol esta lleno. Complejidad, una cosa de orden N + otra cosa de
    // orden N es de orden N, es decir son las llamadas a las dos funciones
    // public boolean estaLleno() {
    // int niveles = treeDepth();
    // int nodos = countNodes();
    //
    // if(Math.pow(2, niveles) - 1) == nodos) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    public static boolean buscarDatosNodo(BinaryTree<Integer> arbol, int dato) {

        if (!arbol.esVacio()) {
            System.out.println("*");
            if (dato == arbol.raiz()) {
                return true;
            } else {
                return buscarDatosNodo(arbol.hijoIzquierdo(), dato) || buscarDatosNodo(arbol.hijoDerecho(), dato);
            }
        } else {
            return false;
        }
    }

    // Hacer la operacion buscar en un arbol binario de busqueda
    public static boolean buscarDatosArbolBin(BinaryTree<Integer> arbol, int dato) {

        if (!arbol.esVacio()) {
            System.out.println("*");
            if (dato == arbol.raiz()) {
                return true;
            } else {
                if (dato < arbol.raiz()) {
                    return buscarDatosArbolBin(arbol.hijoIzquierdo(), dato);
                } else {
                    return buscarDatosArbolBin(arbol.hijoDerecho(), dato);
                }
            }
        } else {
            return false;
        }
    }

    /*
     * 
     * 
     * 
     */
    // String[] niveles;
    // int altura;
    //
    // public int alturaArbol() {
    // altura = 0;
    // devuelveAlturaArbol(raiz, 1); // 1
    // return altura;
    // }
    //
    // public void devuelveAlturaArbol(NodoBin reco, int nivel) {
    // if(reco != null) {
    // devuelveAlturaArbol(reco.hijoIzq, nivel + 1);
    // if(nivel > altura) {
    // altura = nivel;
    // }
    // devuelveAlturaArbol(reco.hijoDcho, nivel + 1);
    // }
    // }
    //
    // public void imprimirNivel() {
    // niveles = new String[altura + 1]; // niveles = new String[altura + 1];
    //
    // imprimirNivel2(raiz, 0);
    // System.out.println(niveles[niveles.length-2] + "En el nivel: " +
    // (niveles.length-1));
    // }
    //
    // public void imprimirNivel2(NodoBin pivote, int nivel2) {
    // if(pivote != null) {
    // niveles[nivel2] = pivote.info + ", " + ((niveles[nivel2] != null) ?
    // niveles[nivel2] : "");
    // imprimirNivel2(pivote.hijoDcho, nivel2 + 1);
    // imprimirNivel2(pivote.hijoIzq, nivel2 + 1);
    // }
    // }

    static String[] niveles;
    static int altura;

    public static int alturaArbol(BinaryTree<String> aA) {
        altura = 0;
        devuelveAlturaArbol(aA.raiz, 1); // 1
        return altura;
    }

    public static void devuelveAlturaArbol(BinaryTree<String>.NodoBin raiz2, int nivel) {
        if (raiz2 != null) {
            devuelveAlturaArbol(raiz2.hijoIzq, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            devuelveAlturaArbol(raiz2.hijoDcho, nivel + 1);
        }
    }

    public static void imprimirNivel(BinaryTree<String> aA) {
        alturaArbol(aA);
        niveles = new String[altura + 1];

        imprimirNivel2(aA.raiz, 0);
        System.out.println(niveles[niveles.length - 2] + "En el nivel: " + (niveles.length - 1));
    }

    public static void imprimirNivel2(BinaryTree<String>.NodoBin pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.info + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel2(pivote.hijoDcho, nivel2 + 1);
            imprimirNivel2(pivote.hijoIzq, nivel2 + 1);
        }
    }

    /*
     * Devuelve el factor de carga (nodosLlenos / total nodos) en funci�n de su
     * profundidad
     */

    public static int profundidad(BinaryTree<Integer> aA) {
        if (aA.esVacio()) {
            return 0;
        } else {
            return 1 + Math.max(profundidad(aA.hijoIzquierdo()), profundidad(aA.hijoDerecho()));
        }
    }

    public static int recorridoPreOrdenArbol(BinaryTree<Integer> aA) {
        int countNodos = 0;
        return auxPreOrdenContador(aA, countNodos);
    }

    public static int auxPreOrdenContador(BinaryTree<Integer> aA, int countNodos) {

        if (aA.raiz() != null) {
            countNodos++;
            System.out.println(aA.raiz.info);
        }

        auxPreOrdenContador(aA.hijoIzquierdo(), countNodos);
        auxPreOrdenContador(aA.hijoDerecho(), countNodos);

        return countNodos;
        // return a;
    }

    public static double factorCarga(BinaryTree<Integer> aA) {
        int profundidad = profundidad(aA);
        double totalNodos = Math.pow(2, profundidad) - 1;// (2^k) - 1

        int nodosArbol = recorridoPreOrdenArbol(aA);

        double fq = nodosArbol / totalNodos;

        return fq;

    }

    public static void main(String[] args) {

        BinaryTree<Integer> vacio = new BinaryTree<Integer>();
        BinaryTree<Integer> a9 = new BinaryTree<Integer>(vacio, 4, vacio);

        BinaryTree<Integer> a1 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 28, new BinaryTree<Integer>());
        BinaryTree<Integer> a2 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 20, a1);
        BinaryTree<Integer> a10 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 80, new BinaryTree<Integer>());
        BinaryTree<Integer> a11 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 60, a10);
        BinaryTree<Integer> a12 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 47, new BinaryTree<Integer>());
        BinaryTree<Integer> a13 = new BinaryTree<Integer>(a12, 56, a11);
        BinaryTree<Integer> a14 = new BinaryTree<Integer>(a2, 40, a13);

        /*
         * ArbolBin<String> a27 = new ArbolBin<String>(new ArbolBin<String>(), "A", new
         * ArbolBin<String>()); ArbolBin<String> a20 = new ArbolBin<String>(new
         * ArbolBin<String>(), 5, new ArbolBin<String>()); ArbolBin<String> a21 = new
         * ArbolBin<String>(a20, 12, a27); ArbolBin<String> a23 = new
         * ArbolBin<String>(new ArbolBin<String>(), 42, new ArbolBin<String>());
         * ArbolBin<String> a22 = new ArbolBin<String>(a21, 22, a23); ArbolBin<String>
         * a24 = new ArbolBin<String>(new ArbolBin<String>(), 56, new
         * ArbolBin<String>()); ArbolBin<String> a25 = new ArbolBin<String>(a24, 72, new
         * ArbolBin<String>()); ArbolBin<String> a26 = new ArbolBin<String>(a22, 52,
         * a25);
         */

        BinaryTree<Integer> a5 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 4, new BinaryTree<Integer>());
        BinaryTree<Integer> a6 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 10, new BinaryTree<Integer>());
        BinaryTree<Integer> a3 = new BinaryTree<Integer>(a1, 6, a2);
        BinaryTree<Integer> a4 = new BinaryTree<Integer>(a1, 5, a2);
        BinaryTree<Integer> a7 = new BinaryTree<Integer>(new BinaryTree<Integer>(), null, new BinaryTree<Integer>());

        // System.out.println(comparaArbol(a3, a4));
        // System.out.println(arbolesSimetricos(a3, a4));
        // System.out.println(recorridoPreOrden(a3));
        // System.out.println(cuentaNodos(a3));
        // System.out.println(buscarDatosArbolBin(a14, 60));
        // System.out.println(buscarDatosNodo(a14, 60));

        /*
         * ARBOL BINARIO CREADO:
         * 
         * C
         * 
         * A S
         * 
         * T E L
         * 
         * L O N
         * 
         */

        // ArbolBin<String> a28 = new ArbolBin<String>(new ArbolBin<String>(), "N", new
        // ArbolBin<String>());
        // ArbolBin<String> a27 = new ArbolBin<String>(new ArbolBin<String>(), "O", new
        // ArbolBin<String>());
        // ArbolBin<String> a20 = new ArbolBin<String>(new ArbolBin<String>(), "L", new
        // ArbolBin<String>());
        // ArbolBin<String> a21 = new ArbolBin<String>(a20, "T", a27);
        // ArbolBin<String> a23 = new ArbolBin<String>(a28, "E", new
        // ArbolBin<String>());
        // ArbolBin<String> a22 = new ArbolBin<String>(a21, "A", a23);
        // ArbolBin<String> a24 = new ArbolBin<String>(new ArbolBin<String>(), "L", new
        // ArbolBin<String>());
        // ArbolBin<String> a25 = new ArbolBin<String>(a24, "S", new
        // ArbolBin<String>());
        // ArbolBin<String> a26 = new ArbolBin<String>(a22, "C", a25);

        BinaryTree<Integer> a28 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 9, new BinaryTree<Integer>());
        BinaryTree<Integer> a27 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 8, new BinaryTree<Integer>());
        BinaryTree<Integer> a20 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 7, new BinaryTree<Integer>());
        BinaryTree<Integer> a21 = new BinaryTree<Integer>(a20, 4, a27);
        BinaryTree<Integer> a23 = new BinaryTree<Integer>(a28, 5, new BinaryTree<Integer>());
        BinaryTree<Integer> a22 = new BinaryTree<Integer>(a21, 2, a23);
        BinaryTree<Integer> a24 = new BinaryTree<Integer>(new BinaryTree<Integer>(), 6, new BinaryTree<Integer>());
        BinaryTree<Integer> a25 = new BinaryTree<Integer>(a24, 3, new BinaryTree<Integer>());
        BinaryTree<Integer> a26 = new BinaryTree<Integer>(a22, 1, a25);

        // System.out.println("La altura del arbol es: " + alturaArbol(a26));
        // imprimirNivel(a26);

        System.out.println(recorridoPreOrdenArbol(a26));
    }
}
