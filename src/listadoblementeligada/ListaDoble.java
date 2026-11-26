/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoblementeligada;

/**
 *
 * @author angel
 */
public class ListaDoble {
    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;

    public ListaDoble(){
        tamanio = 0;
        cabeza=null;
        cola=null;
    }

    public boolean estaVacia()
    {
        if(cabeza==null && cola==null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }

     public boolean buscar (int dato){
        nodoDoble aux = cabeza;
        while(aux != null) // se recorre hasta null para revisar tambien el ultimo nodo (y no truena si esta vacia)
        {
            if(aux.getDato()==dato)
            {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }


    @Override
    public String toString(){
    String res = "";
    nodoDoble aux = cabeza;
    while (aux != null) // recorre hasta el ultimo nodo
    {
        res = res + "<-- [" + aux.getDato() + "] -> ";
        aux = aux.getSiguiente();
    }
    res = res + "NULL";
    return res;
   }

     public nodoDoble obtenerNodo(int pos){
    if(pos <= 0 || pos > tamanio){
        return null;
    }

    nodoDoble aux = cabeza;

    for(int i = 1; i < pos; i++)
    {
        aux = aux.getSiguiente();
    }

    return aux;
}

    public void actualizar(int pos, int dato)
    {
        nodoDoble referencia = obtenerNodo(pos);
        if(referencia == null) // si la posicion no existe obtenerNodo regresa null
        {
            throw new IllegalStateException("Posicion NO valida: " + pos + ", rango valido entre 1 hasta " + tamanio);
        }
        referencia.setDato(dato);
    }

    public void insertarAlinicio(int dato){
        nodoDoble nuevo = new nodoDoble(dato);
        //caso uno en casso de que la lista este vacia
        if(estaVacia())
        {
            cola = nuevo;
        }
        else{
            //caso 2 la lista no esta vacia
             nuevo.setSiguiente(cabeza);
             cabeza.setAnterior(nuevo);
        }
        tamanio++;
        cabeza = nuevo;
    }


    public void insertarAlFinal(int dato){
    nodoDoble nuevo = new nodoDoble(dato);
    // Caso 1: La lista está vacía
    if(estaVacia())
    {
        cabeza = nuevo;
    }
    // Caso 2: La lista tiene elementos
    else
    {
        nuevo.setAnterior(cola);
        cola.setSiguiente(nuevo);
    }
    tamanio++;
    cola = nuevo;
    }

     public int eliminarAlinicio(){
        if(estaVacia())
        {
            throw new IllegalStateException("La lista esta vacia");
        }
        int dato = cabeza.getDato();
        // caso 1: solo hay un nodo
        if(cabeza == cola)
        {
            cabeza = null;
            cola = null;
        }
        // caso 2: hay mas nodos
        else
        {
            cabeza= cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null); // se desconecta el nodo que se elimina
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    public String toStringReversa(){
        String res = "";
        nodoDoble aux = cola;
        while (aux != null)
        {
            res = res + "<-- [" + aux.getDato() + "] -> ";
            aux = aux.getAnterior();
        }
        res = res + "NULL";
        return res;
    }
    
    public void insertarEnPosicion(int pos, int dato){
        if(pos <= 0 || pos > tamanio + 1)
        {
            throw new IllegalStateException("Posicion NO valida: " + pos + ", rango valido entre 1 hasta " + (tamanio + 1));
        }
        // Caso 1: al inicio
        if(pos == 1)
        {
            insertarAlinicio(dato);
            return;
        }
        // Caso 2: al final
        if(pos == tamanio + 1)
        {
            insertarAlFinal(dato);
            return;
        }
        // Caso 3: en medio, el nuevo queda entre anterior y siguiente
        nodoDoble anterior = obtenerNodo(pos - 1);
        nodoDoble siguiente = anterior.getSiguiente();
        nodoDoble nuevo = new nodoDoble(dato);
        
        nuevo.setAnterior(anterior);     // enlaces del nuevo
        nuevo.setSiguiente(siguiente);
        anterior.setSiguiente(nuevo);    // enlace hacia adelante
        siguiente.setAnterior(nuevo);    // enlace hacia atras
        tamanio++;
    }
    
    // Inserta el dato manteniendo la lista ordenada de menor a mayor
    public void insertarOrdenado(int dato)
    {
        // Caso A: la lista esta vacia
        if (estaVacia())
        {
            insertarAlinicio(dato);
            return;
        }
        // Caso B: el dato es menor o igual que la cabeza
        if (dato <= cabeza.getDato())
        {
            insertarAlinicio(dato);
            return;
        }
        // Caso C: el dato es mayor o igual que la cola 
        if (dato >= cola.getDato())
        {
            insertarAlFinal(dato);
            return;
        }
        // Caso D: va en medio, se avanza mientras el siguiente sea menor que el dato
        nodoDoble nuevo = new nodoDoble(dato);
        nodoDoble actual = cabeza;
        while (actual.getSiguiente() != null && actual.getSiguiente().getDato() < dato)
        {
            actual = actual.getSiguiente();
        }
        // el nuevo se mete entre actual y su siguiente
        nodoDoble siguiente = actual.getSiguiente();
        nuevo.setAnterior(actual);
        nuevo.setSiguiente(siguiente);
        actual.setSiguiente(nuevo);
        siguiente.setAnterior(nuevo);
        tamanio++;
    }
    
    // Elimina el ultimo nodo
    public boolean eliminarUltimo(){
        if(estaVacia())
        {
            return false;
        }
        // Caso 1: solo hay un nodo
        if(cabeza == cola)
        {
            cabeza = null;
            cola = null;
        }
        // Caso 2: el penultimo pasa a ser la cola
        else
        {
            nodoDoble penultimo = cola.getAnterior();
            penultimo.setSiguiente(null);
            cola.setAnterior(null);
            cola = penultimo;
        }
        tamanio--;
        return true;
    }
    
    // Elimina el nodo de la posicion pos y regresa su dato
    public int eliminarEnPosicion (int pos){
        if(pos <= 0 || pos > tamanio)
        {
            throw new IllegalStateException("Posicion NO valida: " + pos + ", rango valido entre 1 hasta " + tamanio);
        }
        // Caso 1: es el primero
        if(pos == 1)
        {
            return eliminarAlinicio();
        }
        // Caso 2: es el ultimo
        if(pos == tamanio)
        {
            int res = cola.getDato();
            eliminarUltimo();
            return res;
        }
        // Caso 3: esta en medio
        nodoDoble objetivo = obtenerNodo(pos);
        int res = objetivo.getDato();
        
        objetivo.getAnterior().setSiguiente(objetivo.getSiguiente());
        objetivo.getSiguiente().setAnterior(objetivo.getAnterior());
        objetivo.setAnterior(null);
        objetivo.setSiguiente(null);
        tamanio--;
        return res;
    }
    
    // Elimina la primera aparicion del valor x. Regresa true si lo elimino
    public boolean eliminarPorValor(int x)
    {
        if(estaVacia())
        {
            return false;
        }
        // Caso 1: esta en la cabeza
        if(cabeza.getDato() == x)
        {
            eliminarAlinicio();
            return true;
        }
        // se busca en el resto de la lista
        nodoDoble aux = cabeza.getSiguiente();
        while(aux != null)
        {
            if(aux.getDato() == x)
            {
                // Caso 2: esta en la cola
                if(aux == cola)
                {
                    eliminarUltimo();
                }
                // Caso 3: esta en medio
                else
                {
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                    aux.setAnterior(null);
                    aux.setSiguiente(null);
                    tamanio--;
                }
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
}
