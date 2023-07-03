import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//DFS 문제
// 포인트는 재귀함수와 방문자를 확인한다. 인접행렬 또는 인접리스트를 사용해서 연결한다.
public class 백준11724 {

    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bf.readLine());

        //모든 숫자 카운트
        int totalNum = Integer.parseInt(str.nextToken());

        //입력숫자값 받는부분
        int countNum = Integer.parseInt(str.nextToken());
        int answer = 0;


        isVisited = new boolean[totalNum+1];
        arr = new ArrayList[totalNum+1];


        for(int i=1; i<=totalNum; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<countNum; i++){

            str = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());

            arr[start].add(end);
            arr[end].add(start);

        }


        for(int i =1; i<= totalNum; i++){
            if(!isVisited[i]){
                answer+=1;
                DFS(i);
            }
        }

        System.out.println(answer);

    }

    private static void DFS(int start) {

        if(isVisited[start]) return;
        isVisited[start] = true;
        for (int i : arr[start]) {
            if(!isVisited[i]){
                DFS(i);
            }
        }
    }

}
