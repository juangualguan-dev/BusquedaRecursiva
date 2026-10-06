/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.util.Random;

/**
 *
 * @author 8MQW044
 */
public class BusquedaRecursiva {
    private int[] vector;
    private int logitud;
    
    
    public int[] retornarVector() {
        Random rd = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rd.nextInt(20);

        }
        return vector;
    }

    public BusquedaRecursiva(int logitud) {
        this.vector = new int[logitud];
    }
    
    public  void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("[" + i + "] -> " + vector[i]);

        }
    }
   
 //---Búsqueda secuencial   
    
    static boolean secuencial(int[] vector, int indice, int valor) {
        
        if (indice == vector.length) {
            return false;
        }

        if (vector[indice] == valor) {
            return true;
        }
       
        return secuencial(vector, indice + 1, valor);
    }
   //-------------------------------
    
    //------------------- Busqueda por indice
   public int buscarIndice(int[] vector, int indice, int valor) {
        
        if (indice >= vector.length) {
            return -1;
        }
         
        if (vector[indice] == valor) {
            return indice;
        }

        return buscarIndice(vector, indice + 1, valor);
    }
 
    //---------------------------------------
   //---------------------Búsqueda de todas las ocurrencias
   static void buscarOcurrencias(int[] vector, int indice, int valor) {
     
        if (indice == vector.length) {
            return;
        }

        if (vector[indice] == valor) {
            System.out.println("Encontrado en posición: " + indice);
        }

        buscarOcurrencias(vector, indice + 1, valor);
    }
   //--------------------------------
   
   //-----------------------Búsqueda Binaria Recursiva
   
   public int buscarBinaria(int[] vector, int inicio, int fin, int valor) {

        if (inicio > fin) {
            return -1;
        }
       int medio = (inicio + fin) / 2;
        if (vector[medio] == valor) {
            return medio;
        }
        if (valor < vector[medio]) {
            return buscarBinaria(vector, inicio, medio - 1, valor);
        }
        return buscarBinaria(vector, medio + 1, fin, valor);
    }
//---------------------------------------  
    
 //-------------------------Metodo Main
    
    
    public static void main(String[] args) {

        BusquedaRecursiva busqueda = new BusquedaRecursiva(10);
        int[] vector = busqueda.retornarVector();
        busqueda.imprimirVector(vector);
        int valor = 12;

        //--Búsqueda secuencial
        if (secuencial(vector, 0, valor)) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento no encontrado");
        }
        
        //---Búsqueda por indice
        int posicion = busqueda.buscarIndice(vector, 0, 3);

        if (posicion != -1) {
            System.out.println("Elemento encontrado en la posicion: "
                    + posicion);
        } else {
            System.out.println("Elemento no encontrado");
        }
        
        
        //--Búsqueda por ocurrencias
         busqueda.buscarOcurrencias(vector, 0, 14);
        
        //------Búsqueda binaria 
        
         int pBinaria = busqueda.buscarBinaria(vector, 0, vector.length - 1, valor);
               

        if (pBinaria != -1) {
            System.out.println(
                "Elemento encontrado en la posición: " + pBinaria
            );
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
    
    
}
