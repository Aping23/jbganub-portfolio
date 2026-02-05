import java.util.Random;

public class Birthday {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Birthday <n> <trials>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] counts = new int[n + 1]; // Array to store counts of occurrences
        Random rand = new Random();

        // Run the experiment trials times
        for (int t = 0; t < trials; t++) {
            boolean[] birthdays = new boolean[n]; // Track used birthdays
            int people = 0;

            while (true) {
                int birthday = rand.nextInt(n);
                people++;
                if (birthdays[birthday]) { // If birthday already seen, stop
                    break;
                }
                birthdays[birthday] = true;
            }
            counts[people]++;
        }

        // Print the results
        System.out.println(" i  Count  Fraction");
        double cumulativeFraction = 0.0;

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) continue;

            double fraction = (double) counts[i] / trials;
            cumulativeFraction += fraction;
            System.out.printf("%2d  %5d  %.4f\n", i, counts[i], cumulativeFraction);

            if (cumulativeFraction >= 0.5) {
                break;
            }
        }
    }
}
