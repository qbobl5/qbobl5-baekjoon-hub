import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[65];
        int[] sticks = {1, 2, 4, 8, 16, 32, 64};

        for(int i=0; i<=6; i++) dp[sticks[i]] = 1;
        int index = 1;
        for(int i=3; i<=X; i++) {
            if(sticks[index + 1] <= i) index ++;
            dp[i] = dp[sticks[index]] + dp[i - sticks[index]];
        }
        
        System.out.println(dp[X]);
    }
}