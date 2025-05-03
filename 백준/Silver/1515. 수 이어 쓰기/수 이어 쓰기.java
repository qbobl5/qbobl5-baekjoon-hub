import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int size = input.length();
        int N = 0;
        int index = 0;
        
        while(index < size) {
            N++;
            String number = String.valueOf(N);
            for(int i=0; i<number.length(); i++) {
                if(input.charAt(index) == number.charAt(i)) index++;
                if(index == size) {
                    System.out.println(N);
                    System.exit(0);
                }
            }
        }

        System.out.println(N);
    }
}