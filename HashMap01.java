import java.util.HashMap;

public class HashMap01 {
	/*
	 * Arrays.sort(participant);
	 * Arrays.sort(completion);
	 */

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();			// key,value 순으로 입력
		for (String player : participant)						// participant 개수 만큼 입력
			hm.put(player, hm.getOrDefault(player, 0) + 1);		// 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값 반환
		/*
		 * getOrDefault(Object key, V DefaultVlaue)
		 * key 가져와야하는 요소의 키
		 * defaultValue : 지정된 키로 매핑된 값이 없으면 반환되어야하는 기본 값
		 * 
		 * put(key, value) : key-value 관계로 저장
		 * get(key) : 해당 key에 인자가 되는 value를 리턴해줌
		 * clear, isEmpty, keySet, containsKey, containsValue
		 */
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
}
