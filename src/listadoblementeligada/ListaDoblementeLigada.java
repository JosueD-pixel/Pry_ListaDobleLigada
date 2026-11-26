/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadoblementeligada;
import java.util.Scanner;
/**
 *
 * @author angel
 */
public class ListaDoblementeLigada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();
        int opcion;

        do {
            System.out.println("\nMenu :3");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posicion");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar Ultimo");
            System.out.println("7. Eliminar en posicion");
            System.out.println("8. Eliminar por valor");
            System.out.println("9. Buscar un valor");
            System.out.println("10. Actualizar un valor");
            System.out.println("11. Mostrar la lista (de inicio a fin)");
            System.out.println("12. Mostrar la lista (de fin a inicio)");
            System.out.println("13. Ver tamanio");
            System.out.println("0. Salir");
            System.out.print("OpciOn: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor: ");
                    lista.insertarAlinicio(teclado.nextInt());
                    break;
                case 2:
                    System.out.print("Valor: ");
                    lista.insertarAlFinal(teclado.nextInt());
                    break;
                case 3:
                    System.out.print("Posicion (de 1 a " + (lista.getTamanio() + 1) + "): ");
                    int posInsertar = teclado.nextInt();
                    System.out.print("Valor: ");
                    int valorInsertar = teclado.nextInt();
                    if (posInsertar <= 0 || posInsertar > lista.getTamanio() + 1) {
                        System.out.println("Posicion no valida");
                    } else {
                        lista.insertarEnPosicion(posInsertar, valorInsertar);
                    }
                    break;
                case 4:
                    System.out.print("Valor: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    break;
                case 5:
                    if (lista.estaVacia()) {
                        System.out.println("La lista está vacia");
                    } else {
                        System.out.println("Se elimino: " + lista.eliminarAlinicio());
                    }
                    break;
                case 6:
                    System.out.println(lista.eliminarUltimo()? "Se elimino el último": "La lista esta vacia");
                    break;
                case 7:
                    System.out.print("Posición a eliminar (de 1 a " + lista.getTamanio() + "): ");
                    int posEliminar = teclado.nextInt();
                    if (posEliminar <= 0 || posEliminar > lista.getTamanio()) {
                        System.out.println("Posición no valida");
                    } else {
                        System.out.println("Se elimino: " + lista.eliminarEnPosicion(posEliminar));
                    }
                    break;
                case 8:
                    System.out.print("Valor a eliminar: ");
                    int eliminado = teclado.nextInt();
                    System.out.println(lista.eliminarPorValor(eliminado)? "Eliminado":"No encontrado");
                    break;
                case 9:
                    System.out.print("Valor a buscar: ");
                    int buscado = teclado.nextInt();
                    System.out.println(lista.buscar(buscado)? "Si esta en la lista":"No esta en la lista");
                    break;
                case 10:
                    System.out.print("Posicion a actualizar (de 1 a " + lista.getTamanio() + "): ");
                    int posActualizar = teclado.nextInt();
                    System.out.print("Nuevo valor: ");
                    int nuevoValor = teclado.nextInt();
                    if (posActualizar <= 0 || posActualizar > lista.getTamanio()) {
                        System.out.println("Posicion no valida");
                    } else {
                        lista.actualizar(posActualizar, nuevoValor);
                    }
                    break;
                case 11:
                    System.out.println(lista.toString());
                    break;
                case 12:
                    System.out.println(lista.toStringReversa());
                    break;
                case 13:
                    System.out.println("Tamaño: " + lista.getTamanio());
                    break;
                case 0:
                    System.out.println("tienes tele? pus ahi te vez");
                    break;
                default:
                    System.out.println("SIGUE LAS INSTRUCCIONESSSSSSSSSSSSSSSSSSSSSSSSSS");
            }
        } while (opcion != 0);

        teclado.close();
    }

}
