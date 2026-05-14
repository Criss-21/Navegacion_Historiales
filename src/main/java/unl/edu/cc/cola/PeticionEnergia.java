package unl.edu.cc.cola;

public class PeticionEnergia {
    String idDispositivo;
    double kwhRequeridos;
    long tiempoEntrada;

    public PeticionEnergia(String id, double kwh) {
        this.idDispositivo = id;
        this.kwhRequeridos = kwh;
        this.tiempoEntrada = System.currentTimeMillis();
    }
}
