package productor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author KebFelipe
 */
public class Productor implements Runnable{
     private BlockingQueue<Integer> cola;

    public Productor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 0; i < 1000; i++) {
                int numero = random.nextInt(100) + 1;
                cola.put(numero);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
