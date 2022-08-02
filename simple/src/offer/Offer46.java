package offer;

public class Offer46 {
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int n = src.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String sub = src.substring(i - 2, i);
            int sum = 0;
            if (sub.compareTo("10") < 0 || sub.compareTo("25") > 0) {
                sum = dp[i - 1];
            } else {
                sum = dp[i - 1] + dp[i - 2];
            }

            dp[i] = sum;
        }
        return dp[n];
    }
}
