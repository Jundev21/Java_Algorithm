import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준1874 {





    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int totalSize = Integer.parseInt(buffer.readLine());
        int[] calcStore = new int[totalSize];
        Stack<Integer> stack = new Stack<>();
        int targetNum = 0;
        ArrayList<String> answer= new ArrayList<>();


        for(int i=0; i<totalSize; i++){
            calcStore[i] = Integer.parseInt(buffer.readLine());
        }


        //전체 숫자를 순회하다.

        //만약 현재숫자가 수열보다 클 경우 수열을 계속해서 쌓는다.

        //만약 작을 경우 해당 숫자를 빼고 비교한다.
        for(int i=1; i<= totalSize; i++){

            stack.push(i);
            answer.add("+");
//            스택에 넣고 해당값을 비교한다. 스택에 있는지없는지 계속해서 비교해나아간다
            while(!stack.empty() && calcStore[targetNum] == stack.peek()){
                stack.pop();
                answer.add("-");
                targetNum+=1;
            }

        }

        if(stack.empty()) {

            System.out.println(answer);

        } else{
            System.out.println("NO");
        }

//        while(targetNum < totalSize){
//
//            int getPeek = stack.peek();
//            if(getPeek == calcStore[targetNum]){
//                System.out.println("-");
//                stack.pop();
//            } else{
//                System.out.println("+");
//                stack.push(calcStore[targetNum]);
//            }
//                targetNum+=1;
//        }
//
//        if(!stack.empty()){
//            System.out.println("NO");
//        }

    }
}

















