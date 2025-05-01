import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> max = new PriorityQueue<>();

        int mid = Integer.parseInt(br.readLine());
        sb.append(mid).append("\n");

        for(int i=1; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(min.size() == max.size()) {
                if(mid < input) max.add(input);
                else {
                    min.add(input);
                    max.add(mid);
                    mid = min.poll();
                }
            } else {
                if(mid > input) min.add(input);
                else {
                    min.add(mid);
                    max.add(input);
                    mid = max.poll();
                }
            }
            sb.append(mid).append("\n");
        }

        bw.append(sb.toString());
        bw.close();
    }
}