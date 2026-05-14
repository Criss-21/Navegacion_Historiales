package unl.edu.cc.cola;

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
}
