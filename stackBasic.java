import java.util.*;

class stackBasic {
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		Stack<Integer> progress = new Stack<>();
		Stack<Integer> speed = new Stack<>();

		boolean done = false;
		int task = 0;

		for (int i = progresses.length - 1; i >= 0; i--) {
			progress.push(progresses[i]);
			speed.push(speeds[i]);
		}
		int days = 1;
		while (!progress.empty()) {
			if (progress.peek() + speed.peek() * days >= 100) {
				progress.pop();
				speed.pop();
				done = true;
				task++;
			} else {
				days++;
				if (done) {
					list.add(task);
					task = 0;
					done = false;
				}
			}
			if (progress.empty()) {
				list.add(task);
			}
		}

		int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

		return answer;
	}

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(solution(progresses, speeds));
	}
}
