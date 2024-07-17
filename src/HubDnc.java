import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HubDnc {

	public HashMap<String, Integer> solution(ArrayList<HashMap<String, Integer>> answers) {
		HashMap<String, Integer> solutionAnswer = new HashMap<>();
		HashMap<String, Integer> storeData = new HashMap<>();
		final int personA = 1;
		final int personB = 3;
		final int personC = 5;

		storeData.put("a", 0);
		storeData.put("b", 0);
		storeData.put("c", 0);

		for (HashMap<String, Integer> answer : answers) {

			if (answer.get("answer") == personA) {
				storeData.put("a", storeData.get("a") + answer.get("score"));
			}

			if (answer.get("answer") == personB) {
				storeData.put("b", storeData.get("b") + answer.get("score"));
			}

			if (answer.get("answer") == personC) {
				storeData.put("c", storeData.get("c") + answer.get("score"));
			}
		}

		int findMaxValue = Collections.max(storeData.values());

		for (String currKey : storeData.keySet()) {
			Integer currKeyValue = storeData.get(currKey);

			if (currKeyValue == findMaxValue) {
				solutionAnswer.put(currKey, currKeyValue);
			}
		}

		return solutionAnswer;
	}

	public static void main(String[] args) {

		HashMap<String, Integer> solvedProblem = new HubDnc().solution(
			new ArrayList<>() {{
				add(new HashMap<>() {{
					put("answer", 1);
					put("score", 5);
				}});
				add(new HashMap<>() {{
					put("answer", 3);
					put("score", 3);
				}});
				add(new HashMap<>() {{
					put("answer", 2);
					put("score", 4);
				}});
			}}
		);

		HashMap<String, Integer> solvedProblem2 = new HubDnc().solution(
			new ArrayList<>() {{
				add(new HashMap<>() {{
					put("answer", 1);
					put("score", 5);
				}});
				add(new HashMap<>() {{
					put("answer", 5);
					put("score", 5);
				}});
				add(new HashMap<>() {{
					put("answer", 2);
					put("score", 4);
				}});
			}}
		);

		System.out.println("예제 1)");

		for (String key : solvedProblem.keySet()) {
			System.out.println(key + " : " + solvedProblem.get(key));
		}

		System.out.println("========================================");

		System.out.println("예제 2)");
		for (String key : solvedProblem2.keySet()) {
			System.out.println(key + " : " + solvedProblem2.get(key));
		}

	}
}



