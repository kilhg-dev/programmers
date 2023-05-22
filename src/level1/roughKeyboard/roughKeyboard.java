package level1.roughKeyboard;

import java.util.*;

/**
 * 대충 만든 자판
 * @author kilhyeongyeong
 *
 */
public class roughKeyboard {

	public static void main(String[] args) {
//		TestCase1
//		String[] keymap = {"ABACD", "BCEFD"};
//		String[] targets = {"ABCD","AABB"};
		
//		TestCase2
//		String[] keymap = {"AA"};
//		String[] targets = {"B"};
		
//		TestCase3
		String[] keymap = {"AGZ", "BSSS"};
		String[] targets = {"ASA","BGZ"};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(keymap, targets)));
	}
	
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> cntMap = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            for(int j=keymap[i].length()-1; j>=0; j--){
                if(!cntMap.containsKey(keymap[i].charAt(j))){
                    cntMap.put(keymap[i].charAt(j), j+1);
                }else{
                    if(cntMap.get(keymap[i].charAt(j)) > j+1){
                        cntMap.put(keymap[i].charAt(j), j+1);
                    }
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int sum = 0;
            for(int j=0; j<targets[i].length(); j++){
                if(cntMap.containsKey(targets[i].charAt(j))){
                    sum += cntMap.get(targets[i].charAt(j));
                }else{
                    sum = 0;
                    break;
                }
            }
            answer[i] = sum==0 ? -1 : sum;
        }
        
        return answer;
    }
}
