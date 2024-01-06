import java.util.ArrayList;
import java.util.Collections;

public class threadlar {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }

        int chunkSize = 1000000 / 4;
        ArrayList<Integer>[] numberChunks = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            numberChunks[i] = new ArrayList<Integer>(numbers.subList(i * chunkSize, (i + 1) * chunkSize));
        }

        ArrayList<Integer> commonlist = new ArrayList<Integer>();

        Thread[] threads = new Thread[numberChunks.length];

        for (int c = 0; c < numberChunks.length; c++) {
            final int chunkIndex = c;
            threads[c] = new Thread(() -> {
                
                for (int number : numberChunks[chunkIndex]) {
                    boolean isPrime = true;
                    if (number == 1) continue;
                    for (int j = 2; j * j <= number; j++) {
                        if (number % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        synchronized (commonlist) {
                            commonlist.add(number);
                        }
                    }
                }
            });
            
            threads[c].start();
        }

        for (int i = 0; i < 4; i++) {
            threads[i].join();
        }

        Collections.sort(commonlist);
        System.out.println(commonlist);
    }
}
