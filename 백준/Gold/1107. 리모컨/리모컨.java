import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N == 100) {
            System.out.println(0);
            System.exit(0);
        }
        
        int M = Integer.parseInt(br.readLine());
        boolean[] buttons = new boolean[10];
        
        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) buttons[Integer.parseInt(st.nextToken())] = true;
        }

        int number = N;
        int count = Math.abs(N - 100);
        
        while(number >= 0) {
            String target = String.valueOf(number);
            int size = target.length();
            boolean isPossible = true;
            
            for(int i=0; i<size; i++) {
                int index = target.charAt(i) - '0';
                if(buttons[index]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                count = Math.min(count, size + (N - number));
                break;
            } else number--;
        }

        number = N;
        while(true) {
            String target = String.valueOf(number);
            int size = target.length();
            boolean isPossible = true;
            
            for(int i=0; i<size; i++) {
                int index = target.charAt(i) - '0';
                if(buttons[index]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                count = Math.min(count, size + (number - N));
                break;
            }

            if(size + (number - N) > count) break;
            number++;
        }

        System.out.println(count);
    }
}