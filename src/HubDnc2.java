public class HubDnc2 {

	//최소 공배수는 두수의 곱에서 최대 공약수를 나누면된다.

	public int findGCD(int first, int second) {
		while (first > 0) {
			int remainder = second % first;
			second = first;
			first = remainder;
		}
		return second;
	}

	public int solution(int[] numbers) {
		int answer = 0;

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int gcd = findGCD(numbers[i], numbers[j]);
				int lcm = (numbers[i] * numbers[j]) / gcd;
				answer += lcm;
			}

		}

		return answer;
	}

	public static void main(String[] args) {

		int solvedProblem = new HubDnc2().solution(new int[] {1, 2, 3});


		System.out.println(solvedProblem);
	}
}



