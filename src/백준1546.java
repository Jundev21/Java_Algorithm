public class 백준1546 {

	int count = 0;
	int answer = 0;

	public int solution(String word) {

		char[] charArr = new char[] {'A', 'E', 'I', 'O', 'U'};

		dfs(word, charArr, "");
		return answer;
	}

	public void dfs(String word, char[] charArr, String currWord) {

		if (currWord.equals(word)) {
			answer = count;
		}

		System.out.println(currWord);

		if (currWord.length() == charArr.length) {
			return;

		}

		for (int i = 0; i < charArr.length; i++) {
			count += 1;
			dfs(word, charArr, currWord + charArr[i]);
		}
	}

	public static void main(String[] args) {
		int answer = new 백준1546().solution("AAAAE");

		System.out.println(answer);
	}
}


