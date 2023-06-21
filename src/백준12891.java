import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준12891 {


    static int[] myArr = new int[4];
    static int[] checkArr = new int[4];
    static int checkWords = 0;



    static void Delete(char strChar) {

        switch(strChar){
            case 'A':
                if(checkArr[0] == myArr[0]){
                    checkWords-=1;

                }
                myArr[0]--;
                break;
            case 'C':
                if(checkArr[1] == myArr[1]){
                    checkWords-=1;
                }
                myArr[1]--;
                break;
            case 'G':
                if(checkArr[2] == myArr[2]){
                    checkWords-=1;
                }
                myArr[2]--;
                break;
            case 'T':
                if(checkArr[3] == myArr[3]){
                    checkWords-=1;
                }
                myArr[3]--;
                break;


        }


    }

    public static void Add(char c) {
        switch(c){
            case 'A':
                myArr[0]++;
                if(checkArr[0] == myArr[0]){
                    checkWords+=1;
                }
                break;
            case 'C':
                myArr[1]++;
                if(checkArr[1] == myArr[1]){
                    checkWords+=1;
                }
                break;
            case 'G':
                myArr[2]++;
                if(checkArr[2] == myArr[2]){
                    checkWords+=1;
                }
                break;
            case 'T':
                myArr[3]++;
                if(checkArr[3] == myArr[3]){
                    checkWords+=1;
                }
                break;


        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int totalSize = Integer.parseInt(buffer.readLine());
        int lengthSize = Integer.parseInt(buffer.readLine());
        char[] strChar = new char[totalSize];
        strChar = buffer.readLine().toCharArray();
        StringTokenizer str = new StringTokenizer(buffer.readLine());
        int answer =0;

        for(int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(str.nextToken());
            if( checkArr[i] == 0) checkWords+=1;
        }
        
        for(int i=0; i<lengthSize; i++){
            Add(strChar[i]);
        }

        if (checkWords == 4 ) answer+=1;

        for(int i = lengthSize; i < totalSize; i++){

            int front = i-lengthSize;

            Add(strChar[i]);
            Delete(strChar[front]);

            if(checkWords == 4) answer+=1;

        }


        System.out.println(answer);

    }





}









































