import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 백준11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((el1,el2)->{

            int firstNum = Math.abs(el1);
            int secondNum = Math.abs(el2);

            if(firstNum == secondNum) {
                return el1 > el2 ? 1 : -1;
            }

            return firstNum - secondNum;

        });


        int size = Integer.parseInt(bf.readLine());

        for(int i=0; i<size; i++){

            int currInput = Integer.parseInt(bf.readLine());

            if(currInput == 0){
                if(queue.isEmpty()){
                    arr.add(0);
                }else {
                    arr.add(queue.poll());
                }
            } else{

                queue.add(currInput);
            }


        }

        System.out.println(arr);

    }
}














