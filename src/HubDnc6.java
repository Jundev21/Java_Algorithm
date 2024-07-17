import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HubDnc6 {

	public List<String> solution(String[] participant, String[] completion) {
		List<String> answer = new ArrayList<>();
		HashMap<String, Integer> dataStore = new HashMap<>();

		for (String part : participant) {
			dataStore.put(part, dataStore.getOrDefault(part, 0) + 1);
		}

		for (String complete : completion) {
			dataStore.put(complete, dataStore.get(complete) - 1);
		}

		int findDeath = Collections.max(dataStore.values());

		for (String name : dataStore.keySet()) {
			if (dataStore.get(name) == findDeath) {
				answer.add(name);
			}
		}

		return answer;

	}

	public static void main(String[] args) {

		List<String> answer = new HubDnc6().solution(
			new String[] {"트리케라톱스", "티라노사우르스", "바리오닉스"},
			new String[] {"바리오닉스", "티라노사우르스"}
		);

		System.out.println(answer);
	}
}

// 해쉬 사용하여 키값 벨류값으로 완료된 참가자 체크
// 만약 벨류값이 1이상 남아있는경우 피신못한 참가자로 체크
