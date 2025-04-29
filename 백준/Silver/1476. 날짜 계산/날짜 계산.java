import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int year = 1;
        
        while(E != e || S != s || M != m) {
            e = e == 15 ? 1 : e + 1;
            s = s == 28 ? 1 : s + 1;
            m = m == 19 ? 1 : m + 1;
            year++;
        }

        System.out.println(year);
    }
}