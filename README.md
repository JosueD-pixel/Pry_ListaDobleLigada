# Lista Doblemente Ligada

Alumno: Angel Josue Domingo Guillen
Grupo: 4 C
Matricula: 20251011
Materia: Estructura de Datos
Profesor: Luis Alberto Mendoza San Juan

## Descripcion

Practica donde se completo la clase ListaDoble para que tenga los mismos metodos
que la ListaLigada vista en clase, pero usando doble enlace (anterior y siguiente)
y los apuntadores cabeza y cola.

El proyecto esta hecho en Java con NetBeans.

## Clases

- nodoDoble: guarda el dato y las referencias al nodo anterior y al siguiente.
- ListaDoble: la lista con todos sus metodos.
- ListaDoblementeLigada: el main, con un menu para probar cada metodo.

## Metodos que se agregaron

- insertarEnPosicion(int pos, int dato)
- insertarOrdenado(int dato)
- eliminarEnPosicion(int pos) : int
- eliminarPorValor(int x) : boolean
- eliminarUltimo() : boolean
- toStringReversa(): muestra la lista de la cola a la cabeza, para revisar que
  los enlaces hacia atras esten bien.


## Como ejecutarlo

Abrir el proyecto en NetBeans y correrlo con Shift + F6. Se muestra el menu en
la consola y se elige la opcion del metodo que se quiere probar.
