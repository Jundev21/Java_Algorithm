//2 7 4 1 5 3 의 고유한 번호 두개가 합쳐져서 9가 나와야한다.
// 두개의 번호를 합쳐서 결과값이 나오기위해서는 정렬을 한 후 큰 값과 작은 값들을 더해 나아간다.
// 투포인터는 구간합 또는 두개의 합을 얻기위해 사용되는 알고리즘이다
// 이중 포문을 사용하면 시간복잡도는 n 제곱으로 나오지만
// 투포인터를 사용하면 n 제곱이아닌 n 으로나와 시간복잡도가 현저히 떨어진다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1940 {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int totalSize = Integer.parseInt(buffer.readLine());
        int targetNum = Integer.parseInt(buffer.readLine());
        int[] needs = new int[totalSize];

        StringTokenizer str = new StringTokenizer(buffer.readLine());

        for(int i=0; i<totalSize; i++){
            needs[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(needs);

        int start = 0;
        int answer =0;
        int end = totalSize-1;
        while(start < end ){

            int sum = needs[start] + needs[end];

            if(sum == targetNum){
                start+=1;
                end-=1;
                answer+=1;
            }else if( sum < targetNum){
                start+=1;
            }else{
                end-=1;
            }

        }

        System.out.println(answer);

    }
}
