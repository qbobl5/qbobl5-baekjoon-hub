import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] height = new int[9];
        int sum = -100;
        
        for(int i=0; i<9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);

        int fake1 = 0, fake2 = 0;
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(height[i] + height[j] == sum) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
        }

        for(int i=0; i<9; i++) if(i != fake1 && i != fake2) sb.append(height[i]).append("\n");
        System.out.println(sb);
    }
}