package productor;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author KebFelipe
 */
public class Consumidor implements Runnable{
    private BlockingQueue<Integer> cola;
    private int[] categorias = new int[10]; // Para contar las categorías

    public Consumidor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                int numero = cola.take();
                categorizar(numero);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void categorizar(int numero) {
        int indice = (numero - 1) / 10;
        categorias[indice]++;
    }

    public void mostrarResultados() {
        for (int i = 0; i < categorias.length; i++) {
            int rangoInferior = i * 10 + 1;
            int rangoSuperior = (i + 1) * 10;
            System.out.println("Números entre " + rangoInferior + " y " + rangoSuperior + ": " + categorias[i]);
        }
    }
}
