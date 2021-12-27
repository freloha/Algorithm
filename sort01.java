import java.util.*;

class sort01 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < commands.length; i++){
            int[] sort = new int[commands[i][1]-commands[i][0] + 1];
            int index = 0;
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                sort[index++] = array[j - 1];
            }
            Arrays.sort(sort);
            list.add(sort[commands[i][2] - 1]);
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] array = {1,5,2,6,3,7,4};
    	int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
    	solution(array,commands);
    }
}
