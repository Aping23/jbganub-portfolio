public class ThueMorse {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ThueMorse <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // Generate and print the Thue-Morse matrix without a separate function
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int countI = 0, countJ = 0;
                int tempI = i, tempJ = j;

                while (tempI > 0) {
                    countI += tempI & 1;
                    tempI >>= 1;
                }

                while (tempJ > 0) {
                    countJ += tempJ & 1;
                    tempJ >>= 1;
                }

                int value = (countI % 2) ^ (countJ % 2);
                System.out.print((value == 0 ? "+" : "-") + "  ");
            }
            System.out.println();
        }
    }
}
