
import java.util.ArrayList;
import java.util.List;

public class Permutation {

	static class a {

		List<String> answerList = new ArrayList<>();
		boolean[] isVisited = null;
		int[] numList = null;
		int pickedNum = 0;

		a(int[] numList, int pickedNum) {
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
		a answer = new a(new int[] {1, 2, 3}, 3);
		System.out.println(answer.getPermutation());
		System.out.println(answer.getSize());
	}
}







