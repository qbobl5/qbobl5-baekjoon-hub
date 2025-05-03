import java.io.*;

class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int N;
    static int[][] board;
    
    static int colorToInteger(char color) {
        if(color == 'C') return 0;
        if(color == 'P') return 1;
        if(color == 'Z') return 2;
        else return 3;
    }

    static int check() {
        int max = 0;
        
        for(int i=0; i<N; i++) {
            int current = board[i][0];
            int count = 1;
            for(int j=1; j<N; j++) {
                if(current == board[i][j]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                    current = board[i][j];
                }
            }
            max = Math.max(max, count);
        }

        for(int i=0; i<N; i++) {
            int current = board[0][i];
            int count = 1;
            for(int j=1; j<N; j++) {
                if(current == board[j][i]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                    current = board[j][i];
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) board[i][j] = colorToInteger(input.charAt(j));
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<2; k++) {
                    int row = i + dx[k];
                    int col = j + dy[k];
                    if(row >= N || col >= N || board[i][j] == board[row][col]) continue;

                    int temp = board[i][j];
                    board[i][j] = board[row][col];
                    board[row][col] = temp;
                    max = Math.max(max, check());
                    
                    board[row][col] = board[i][j];
                    board[i][j] = temp;
                }
            }
        }

        System.out.println(max);
    }
}