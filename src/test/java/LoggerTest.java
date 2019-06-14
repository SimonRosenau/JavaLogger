import de.rosenau.simon.logger.Logger;

/**
 * Created by IntelliJ IDEA.
 * Author: Simon Rosenau
 * Date: 15.06.2019
 * Time: 01:08
 */

public class LoggerTest {

    public static void main(String[] args) {
        Logger.initialize();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int o = 0; o < 100; o++) {
                    test();
                }
            }, "Thread-" + i).start();
        }
    }

    private static void test() {
        System.out.println("Output Message");
    }

}
