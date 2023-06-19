// 배열과 리스트...

// 배열은 사이즈만큼 메모리에 차례대로 저장하고 읽는다
// 기본 리스트는 메몰

import java.util.Scanner;

public class 백준1546 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String[] stringScores = in.nextLine().split(" ");
        int[] scores =new int[size];

        double totalAvg =0;
        double maxScore =0;

        for(int i=0; i<size; i++){
            scores[i] = Integer.parseInt(stringScores[i]);
            maxScore = Math.max(maxScore,scores[i]);
        }


        for(int i=0; i<size; i++){

            totalAvg+= scores[i]/maxScore*100;

        }

        System.out.println(totalAvg/size);


    }
}
