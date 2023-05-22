package level1.runningGame;

import java.util.*;

/**
 * 달리기 경주
 * @author kilhyeongyeong
 *
 */
public class runningGame {

	public static void main(String[] args) {
		
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(players, callings)));
	}

}

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String answer[] = new String[players.length];
        Map<String, Integer> playersMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        for(int i=0; i<players.length; i++){
            playersMap.put(players[i], i);
            rankMap.put(i, players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            String currPlayer = callings[i];
            int currRank = playersMap.get(currPlayer);
            String priorPlayer = rankMap.get(currRank-1);
            
            playersMap.put(currPlayer, currRank-1);
            playersMap.put(priorPlayer, currRank);
            
            rankMap.put(currRank, priorPlayer);
            rankMap.put(currRank-1, currPlayer);
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = rankMap.get(i);
        }
        
        return answer;
    }
}
