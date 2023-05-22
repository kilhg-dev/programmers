package level1.failRate;

import java.util.*;

/**
 * 실패율
 * @author kilhyeongyeong
 *
 */
public class failRate {

	public static void main(String[] args) {
//		TestCase1
//		int N = 5;
//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
//		TestCase1
		int N = 4;
		int[] stages = {4,4,4,4,4};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(N, stages)));
	}

}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 0.stage init
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=N; i++){
            map.put(i, 0);
        }
        
        // 1.stage setting
        for(int i : stages){
            if(i != N+1) map.put(i, map.get(i)+1);
        }
        
        // 2.failRate setting
        Map<Integer, Double> rateMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            int denomi = stages.length;
            for(int j=1; j<i; j++){
                denomi -= map.get(j);
            }
            rateMap.put(i, denomi==0 ? 0 : (double)map.get(i)/denomi);
        }
        
        // 3.sort
        List<Integer> list = new ArrayList<>(rateMap.keySet());
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                if(rateMap.get(i1) == rateMap.get(i2)) return i2.compareTo(i1);
                return rateMap.get(i2).compareTo(rateMap.get(i1));
            }
        });
        
        // 4.result
        for(int i=0; i<N; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
