import java.util.Random;

public class DiscreteDistribution {
    public static void main(String[] args) {
        // Read m from the first command-line argument
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n];
        int[] S = new int[n + 1];

        // Parse the input array and compute cumulative sums
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
            S[i + 1] = S[i] + a[i];
        }

        Random rand = new Random();

        // Generate m random indices
        for (int j = 0; j < m; j++) {
            int r = rand.nextInt(S[n]); // Random integer in [0, S[n]-1]

            // Implement binary search inline
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (S[mid] > r) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            System.out.print(left + " ");
        }
    }
}
