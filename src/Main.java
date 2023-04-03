public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int s = sc.nextInt();
        int[] x = new int[a];
        for (int i = 0; i < a; i++) {
            x[i] = sc.nextInt();
        }
        int[] y = new int[a + 1];
        for (int i = 0; i < s; i++) {
            y[sc.nextInt()] = sc.nextInt();
        }
        for (int i = 0; i < a; i++) {
            x[i] = sc.nextInt();
        }
        sc.close();

        long[][] dp = new long[a + 1][a + 1];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + x[i] + y[j + 1]);
                dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][j]);
            }
        }

        long ans = 0;
        for (int i = 0; i <= a; i++) {
            ans = Math.max(ans, dp[a][i]);
        }
        System.out.println(ans);
    }
}