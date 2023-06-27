import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        for(int i=0; i<size; i++){

            int num = Integer.parseInt(br.readLine());
            arr[i] = num;

        }



        for(int i = 0; i< size; i++){

            for(int j=1; j<size-i; j++){

                int before = j-1;

                if( arr[before] > arr[j]){
                    int temp = arr[before];
                    arr[before] = arr[j];
                    arr[j] = temp;

                }

            }

        }


        for(int i : arr){
            System.out.println(i);
        }


    }
}
