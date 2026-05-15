package unl.edu.cc.cola;
/*
Author: Leonel Lima (LMess131)
 */
public class Simulacion {

    public static void main(String[] args) throws InterruptedException {

        ColaEnergia cola = new ColaEnergia();
        int contadorEspera = 0;

        // Paso 1: Se elabora una rafaga inicial de 10 peticiones
        System.out.println(" Rafaga 1: 10 peticiones");
        for (int i = 1; i <= 10; i++) {
            PeticionEnergia p = new PeticionEnergia("DEV-" + i, 1 + Math.random() * 9);
            cola.encolar(p);
            System.out.println("Peticion [" + p.idDispositivo + "] encolada");
        }

        // Paso 2: Luego se procesa 5 peticiones
        System.out.println("\n Procesando 5 peticiones");
        for (int i = 0; i < 5; i++) {
            PeticionEnergia p = cola.desencolar();
            System.out.println("Peticion [" + p.idDispositivo
                    + "] atendida -> Energia entregada: "
                    + String.format("%.1f", p.kwhRequeridos) + " kWh");
        }

        // Paso 3: Segunda rafaga de 5 peticiones
        System.out.println("\n Raafaga 2: 5 peticiones");
        for (int i = 11; i <= 15; i++) {
            PeticionEnergia p = new PeticionEnergia("DEV-" + i, 1 + Math.random() * 9);
            cola.encolar(p);
            System.out.println("Peticion [" + p.idDispositivo + "] encolada");
        }

        // Reto Green Computing: Aqui vaciamos toda la cola, luego verificamos
        // y ponemos el proceso en estado de espera.
        System.out.println("\n Vaciando cola");
        while (!cola.estaVacia()) {
            PeticionEnergia p = cola.desencolar();
            System.out.println("Peticion [" + p.idDispositivo
                    + "] atendida -> Energia entregada: "
                    + String.format("%.1f", p.kwhRequeridos) + " kWh");
        }
        if (cola.verificarYEsperar()) {
            contadorEspera++;
            System.out.println("\n Cola vacia - sistema en estado de espera (500 ms)");
        }

    }
}