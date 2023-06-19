import java.util.Arrays;
import java.util.Scanner;

public class 백준11720{

    public static void main(String[] args){


        // next 는 한단어만읽는다
        // nextLine 줄 바꿈까지 전체를 읽는다.
        // nextInt를 사용하고 nextLine 을 하용하게되면 nextint 를 읽고 다음 공백을 nextLine 이 읽기 때문에 정상동작을 하지 않는다.
        // next 는 개행문자를 무시하고 nextline 은 개행문자를 포함한다.

        Scanner in = new Scanner(System.in);

        int totalSum = 0;
        String currNum = in.nextLine();
        String[] arr = currNum.split("");

        System.out.println(Arrays.toString(arr));
        System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));

    }


}