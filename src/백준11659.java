//구간합...
// 구간합은 배열에서 어디부터 어디까지의 합을 찾아야하는지에대한 정보를 쉽게 구할 수 있다.

import java.util.Arrays;
import java.util.Scanner;

public class 백준11659 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(" ");
        int size = Integer.parseInt(info[0]);
        int counts = Integer.parseInt(info[1]);
        int[] sums = new int[size];

        for(int i=0; i<size; i++){
            int getNums = Integer.parseInt(in.next());

            if(i == 0){
                sums[0] = getNums;
                continue;
            }

            sums[i] = sums[i-1] + getNums;
        }


        System.out.println(Arrays.toString(sums));
        for(int i=0; i<counts; i++){

            int answer = 0;
            int start = Integer.parseInt(in.next())-2;
            int end  = Integer.parseInt(in.next())-1;

            if(start< 0){
                System.out.println(sums[end]);
            }else{

                System.out.println(sums[end] - sums[start]);
            }

        }

    }
}
