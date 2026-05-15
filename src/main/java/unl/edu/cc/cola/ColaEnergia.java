package unl.edu.cc.cola;
/*
Author: Cristian Guaman (Ego_Code)
 */
public class ColaEnergia {
    private Nodo frente; // El que sale
    private Nodo fin;    // El que entra
    private int contador;

    private class Nodo {
        PeticionEnergia dato;
        Nodo siguiente;
        Nodo(PeticionEnergia d) { this.dato = d; }
    }

    // Insertar al final (Rear)
    public void encolar(PeticionEnergia p) {
        Nodo nuevo = new Nodo(p);
        if (fin != null) {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (frente == null) {
            frente = nuevo;
        }
        contador++;
        System.out.println("Peticion [" + p.idDispositivo + "] encolada");
    }

    // Atender al inicio (Front)
    public PeticionEnergia desencolar() {
        if (frente == null) return null;
        PeticionEnergia p = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        contador--;
        return p;
    }

    /*
    Author: Leonel Lima (LMess131)
     */

    // Reto Green Computing: si la cola está vacía, duerme el hilo
    // para no consumir ciclos de CPU innecesarios.
    public boolean verificarYEsperar() throws InterruptedException {
        if (frente == null) {
            Thread.sleep(500);
            return true;
        }
        return false;
    }

    public boolean estaVacia() { return frente == null; }
}