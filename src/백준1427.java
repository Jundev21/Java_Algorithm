
//선택정렬 내림차순으로 정렬하기
// 내림차순이니 최댓값을 찾고 스왑하는 방식으로 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int[] intArr = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int size = arr.length;

        for(int i=0; i<size; i++) {

            int findMaxIdx = i;

            for (int j = i + 1; j < size; j++) {

                if (intArr[findMaxIdx] < intArr[j]) {
                    findMaxIdx = j;
                }

            }

            if (intArr[i] < intArr[findMaxIdx]) {

                int temp = intArr[findMaxIdx];
                intArr[findMaxIdx] = intArr[i];
                intArr[i] = temp;

            }
        }

        System.out.println(Arrays.toString(intArr));

    }

}
