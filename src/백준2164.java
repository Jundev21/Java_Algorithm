import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 백준2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=size ; i++){
            queue.add(i);
        }


        while(queue.size() != 1){

            int dropBottom =0;

            if(!queue.isEmpty()){
                queue.remove();

            }
            if(!queue.isEmpty()){
                dropBottom = queue.poll();
                queue.add(dropBottom);

            }

        }

        System.out.println(queue.poll());

    }

}















