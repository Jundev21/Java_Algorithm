import java.util.ArrayList;
import java.util.List;

public class HubDnc4 {

	public int solution(int numbers) {
		int answer = 0;

		for (int i = 2; i <= numbers; i++) {
			boolean isPrime = true;
			for (int j = 2; j < numbers; j++) {
				if (i != j && i % j == 0) {
					isPrime = false;
				}
			}

			if (isPrime) {
				answer += i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		List<Integer> test = new ArrayList<>(List.of(5, 10, 30));

		for (Integer testNum : test) {
			System.out.println("a:" + testNum + "->" + new HubDnc4().solution(testNum));
		}
	}
}



