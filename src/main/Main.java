package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import productor.Consumidor;
import productor.Productor;

/**
 *
 * @author KebFelipe
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(1000);

        Productor productor = new Productor(cola);
        Consumidor consumidor = new Consumidor(cola);

        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);
        
        hiloProductor.start();
        hiloConsumidor.start();

        try {
            hiloProductor.join();
            hiloConsumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumidor.mostrarResultados();
    }
}
