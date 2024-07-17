 SELECT name,

 CASE

 WHEN absent ≥4 THEN ‘F’

 WHEN score ≥ 90 THEN ‘A’

 WHEN score ≥ 80 THEN ‘B’

 WHEN score ≥ 70 THEN 'C’

 WHEN score ≥ 60 THEN 'D’

 ELSE ‘F’

 END AS grade

 FROM table;


 //


SELECT a.notice_dept, a.title, a.view_count, a.post_date
FROM companyA AS a
INNER JOIN (
        SELECT notice_dept, MAX(post_date) AS latest_date
        FROM companyA
        GROUP BY notice_dept
   ) AS subA
ON a.notice_dept = subA.notice_dept AND a.post_date = subA.latest_date;



퀵소트는 정렬 알고리즘 중에 가장 빠른 시간복잡도를 갖고 있습니다.
퀵소트는 정렬해야할 숫자 배열 에서 기준점을 잡습니다. 보통 기준점은 중간기준으로 잡고 이 기준점을 피벗이라고 합니다.
오름차순일 경우에는 피벗의 값을 기준으로 왼쪽은 작은값들, 오른쪽은 큰값들을 차례대로 담습니다. (내림차순일 경우에는 반대)
최선의 선택은 모든 피벗들을 항상 중간값을 잡았을 경우인데 이럴 경우에는 계속해서 ½씩 줄어듭니다.

n 개의 숫자를 logn 번씩 하면됨으로 O(nlogn) 입니다.
최악의 경우는 만약  피벗의 숫자들가 항상 최댓값 또는 최솟값을 잡았을 경우에는 모든 숫자들은 n개의 숫자를 n 번씩 퀵정렬을 해야함으로 O(n^2) 이 나옵니다.
따라서 최선은O (nlogn) 의 알고리즘을 갖으며 최악의 경우는 O(n^2) 이 나옵니다. (답: 3번)


/////////////////

시간 복잡도를 빅오로 표현할 수 있는 코드를 작성해 주세요…..?

import java.util.Arrays;

// 버블 정렬
// [7,5,1,2,4,3,8]
// 처음부터 끝까지 두개씩 비교하며 교환해나아간다.
public class BubbleSort {
	public static void main(String[] args) {
		int[] basicData = new int[] {7, 5, 1, 2, 4, 3, 8};

		for (int i = 1; i < basicData.length; i++) {
			for (int j = 0; j < basicData.length - 1; j++) {
				if (basicData[j + 1] < basicData[j]) {
					int temp = basicData[j];
					basicData[j] = basicData[j + 1];
					basicData[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(basicData));
	}

}


구현하기 쉬운 버블정렬로 작성하였으며 오름차순 정렬하였습니다.

이중포문으로 두개의 숫자를 처음부터 하나씩 비교해가며 가장 끝 숫자대로 차례대로 정렬을합니다.

따라서 O(n^2) 의 시간복잡도가 걸립니다.


=================================


순열의 개수 구하는 코드

import java.util.ArrayList;
import java.util.List;

public class HubDnc5 {

    static class Permutaion {

       List<String> answerList = new ArrayList<>();
       boolean[] isVisited = null;
       int[] numList = null;
       int pickedNum = 0;

       Permutaion(int[] numList, int pickedNum) {
          this.numList = numList;
          this.pickedNum = pickedNum;
          this.isVisited = new boolean[numList.length];
       }

       public List<String> getPermutation() {
          dfs(new StringBuilder());
          return answerList;
       }

       public int getSize() {
          return answerList.size();
       }

       public void dfs(StringBuilder currentNum) {

          if (currentNum.length() == pickedNum) {
             answerList.add(currentNum.toString());
             return;
          }

          for (int i = 0; i < numList.length; i++) {
             if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(currentNum.append(numList[i]));
                currentNum.deleteCharAt(currentNum.length() - 1);
                isVisited[i] = false;
             }
          }

       }

    }

    public static void main(String[] args) {

       // 순열의 갯수 nPr
       Permutaion answer = new Permutaion(new int[]{1,2,3}, 3);
       System.out.println(answer.getPermutation());
       System.out.println(answer.getSize());
    }
}







