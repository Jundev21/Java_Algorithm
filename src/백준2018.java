


// 입력된수의 방법 가지수를 구해라.
// 이전에 했던 방법으로 부분합을 구할 수 있다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


// 15를 연속된 숫자로 몇가지 방법이 있는지 찾아라...
// 몇가지 방법이라고하면 방법 수를 찾을 수 있겠지만 방법 수 가아닌 연속된 수를 찾아야한다.
// 처음 두개의 포인터가 시작점을 가리키고
// 더한 숫자가 15보다 작으면 끝 포인터가 뒤로 하나씩 밀려간다
// 만약 15보다 크면 앞의 포인터를 하나씩 움직이면서 빼나아간다.
public class 백준2018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(str.nextToken());

        // 다양한 연속된 수를 구하기 우해서는 투포인터를 사용한다.
        // 투포인터는 start,end 가 두개 다 처음으로 시작한다.

        int sum = 0;
        int answer = 1;
        int start = 0;
        int end = 0;
        // for 문을 사용할 수 없다 왜냐하면 for 문은 회전수가 정해져있기때문에 두 포인터들을 전체적으로 순환하기 어렵다.

        while(end != size){

            if(sum == size) {
                answer += 1;
                end += 1;
                sum+= end;
            } else if( sum < size) {
                end += 1;
                sum+=end;
            } else{
                sum-=start;
                start+=1;
            }

        }


        System.out.println("answer" + answer);













































    }


}
