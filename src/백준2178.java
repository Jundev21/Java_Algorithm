//BFS 큐 사용 인접리스트 사용 (인접리스트는 이차원 어레이 리스트로 사용)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int row;
    static int column;
    static Queue<Integer> queue;
    static int[] xDir = {0,1,0,-1};
    static int[] yDir = {1,0,-1,0};



    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(str.nextToken());
        column = Integer.parseInt(str.nextToken());

        arr = new int[row][column];
        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            str = new StringTokenizer(bf.readLine());
            String currStr = str.nextToken();
            for (int j = 0; j < column; j++) {
                arr[i][j] = Integer.parseInt(currStr.substring(j, j + 1));
            }
        }

        BFS(0, 0);

        System.out.println(arr[row-1][column-1]);

    }

    private static void BFS(int a, int b) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a, b});
            visited[a][b] = true;

        while (!queue.isEmpty()) {

            int[] currQue = queue.poll();

            for(int i=0; i<4; i++){

                int dx = currQue[0] + xDir[i];
                int dy = currQue[1] + yDir[i];

                if (dx >= 0 && dy >= 0 && dx < row && dy < column) {

                    if (!visited[dx][dy] && arr[dx][dy] != 0) {
                        visited[dx][dy] = true;

                        //다음 노드층을 현재 노드층에서 더해나아간다.
                        arr[dx][dy] = arr[currQue[0]][currQue[1]]+1;
                        queue.add(new int[]{dx, dy});
                    }

                }

            }

        }


    }

}


