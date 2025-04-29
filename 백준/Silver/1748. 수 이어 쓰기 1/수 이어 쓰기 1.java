import java.io.*;

class Main {
    static int[] count = {0, 9, 90, 900, 9000, 90000, 900000, 9000000, 90000000};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int size = 0;
        int length = input.length();
        for(int i=1; i<length; i++) size += i * count[i];
        size += length * (N - Math.pow(10, length - 1) + 1);

        System.out.println(size);
    }
}