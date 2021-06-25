import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static int parseArg(String arg, String option) {
        int value = 0;
        if (!arg.substring(0, option.length() + 3).equals("--" + option +"=")
                || (value = Integer.parseInt(arg.substring(option.length() + 3))) < 0) {
            System.err.println("Invalid arg!");
            System.exit(-1);
        }
        return (value);
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid arg!");
            System.exit(-1);
        }
        int arraySize = parseArg(args[0], "arraySize");
        int threadsCount = parseArg(args[1], "threadsCount");
        ArrayList<Integer> array = new ArrayList<>(arraySize);
        Random random = new Random();
        long sum = 0;
        for (int i = 0; i < arraySize; ++i) {
            array.add(random.nextInt() % 1001);
            sum += array.get(i);
        }
        System.out.println("Sum: " + sum);
        ArrayList<CalcThread> threads = new ArrayList<>(threadsCount);
        int sizeToCalc = arraySize / threadsCount + (arraySize % threadsCount >= threadsCount / 2 ? 1 : 0);
        for (int i = 0; i < threadsCount; ++i) {
            if (i != threadsCount - 1)
                threads.add(new CalcThread(array, i * sizeToCalc, (i + 1) * (sizeToCalc) - 1));
            else {
                threads.add(new CalcThread(array, i * sizeToCalc, arraySize - 1));
            }
            threads.get(i).start();
        }
        sum = 0;
        for (int i = 0; i < threadsCount; ++i) {
            try {
                threads.get(i).join();
                sum += threads.get(i).getSum();
                System.out.println(threads.get(i));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
        System.out.println("Sum by threads: " + sum);
    }
}
