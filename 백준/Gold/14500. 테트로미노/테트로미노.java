import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] paper;
    
    static int countFourBlock() {
        int max = 0;
        
        for(int[] arr:paper) {
            int index = 0;
            int sum = arr[0] + arr[1] + arr[2] + arr[3];
            max = Math.max(max, sum);
            for(int i=4; i<M; i++) {
                sum -= arr[index++];
                sum += arr[i];
                max = Math.max(max, sum);
            }
        }

        for(int j=0; j<M; j++) {
            int index = 0;
            int sum = paper[0][j] + paper[1][j] + paper[2][j] + paper[3][j];
            max = Math.max(max, sum);
            for(int i=4; i<N; i++) {
                sum -= paper[index++][j];
                sum += paper[i][j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    static int countThreeBlock() {
        int max = 0;
        int[] dx = {-1, -1, -1, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1};
        
        for(int i=0; i<N; i++) {
            int center = 1;
            int sum = paper[i][0] + paper[i][1] + paper[i][2];
            
            for(int j=3; j<M; j++) {
                int add = 0;
                for(int k=0; k<6; k++) {
                    int row = i + dx[k];
                    int col = center + dy[k];
                    if(row < 0 || col < 0 || row >= N || col >= M) continue;
                    add = Math.max(add, paper[row][col]);
                }
                sum += add;
                max = Math.max(max, sum);
                sum -= add;
                sum -= paper[i][center - 1];
                center++;
                sum += paper[i][j];
            }

            int add = 0;
            for(int k=0; k<6; k++) {
                int row = i + dx[k];
                int col = center + dy[k];
                if(row < 0 || col < 0 || row >= N || col >= M) continue;
                add = Math.max(add, paper[row][col]);
            }
            sum += add;
            max = Math.max(max, sum);
        }

        for(int j=0; j<M; j++) {
            int center = 1;
            int sum = paper[0][j] + paper[1][j] + paper[2][j];
            
            for(int i=3; i<N; i++) {
                int add = 0;
                for(int k=0; k<6; k++) {
                    int row = center + dy[k];
                    int col = j + dx[k];
                    if(row < 0 || col < 0 || row >= N || col >= M) continue;
                    add = Math.max(add, paper[row][col]);
                }
                sum += add;
                max = Math.max(max, sum);
                sum -= add;
                sum -= paper[center - 1][j];
                center++;
                sum += paper[i][j];
            }

            int add = 0;
            for(int k=0; k<6; k++) {
                int row = center + dy[k];
                int col = j + dx[k];
                if(row < 0 || col < 0 || row >= N || col >= M) continue;
                add = Math.max(add, paper[row][col]);
            }
            sum += add;
            max = Math.max(max, sum);
        }

        return max;
    }

    static int countTwoBlock() {
        int max = 0;
        int[] dist = {-1, 0, 1, 2};
        
        for(int i=0; i<N-1; i++) {
            int index = 0;
            int sum = paper[i][0] + paper[i][1];
            int row = i + 1;
            
            for(int j=2; j<M; j++) {
                int add = 0;
                for(int k=0; k<3; k++) {
                    int col1 = index + dist[k];
                    int col2 = index + dist[k + 1];
                    if(col1 < 0 || col2 < 0 || col1 >= M || col2 >= M) continue;
                    add = Math.max(add, paper[row][col1] + paper[row][col2]);
                }
                sum += add;
                max = Math.max(max, sum);
                sum -= add;
                sum -= paper[i][index++];
                sum += paper[i][j];
            }

            int add = paper[row][index] + Math.max(paper[row][index - 1], paper[row][index + 1]);
            sum += add;
            max = Math.max(max, sum);
        }

        for(int j=0; j<M-1; j++) {
            int index = 0;
            int sum = paper[0][j] + paper[1][j];
            int col = j + 1;
            
            for(int i=2; i<N; i++) {
                int add = 0;
                for(int k=0; k<3; k++) {
                    int row1 = index + dist[k];
                    int row2 = index + dist[k + 1];
                    if(row1 < 0 || row2 < 0 || row1 >= N || row2 >= N) continue;
                    add = Math.max(add, paper[row1][col] + paper[row2][col]);
                }
                sum += add;
                max = Math.max(max, sum);
                sum -= add;
                sum -= paper[index++][j];
                sum += paper[i][j];
            }

            int add = paper[index][col] + Math.max(paper[index - 1][col], paper[index + 1][col]);
            sum += add;
            max = Math.max(max, sum);
        }

        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) paper[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(countFourBlock(), Math.max(countThreeBlock(), countTwoBlock())));
    }
}