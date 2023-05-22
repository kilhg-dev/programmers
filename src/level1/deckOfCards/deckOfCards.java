package level1.deckOfCards;

import java.util.*;

/**
 * 카드 뭉치
 * @author kilhyeongyeong
 *
 */
public class deckOfCards {

	public static void main(String[] args) {
//		TestCase1
//		String[] cards1 = {"i", "drink", "water"};
//		String[] cards2 = {"want", "to"};
//		String[] goal = {"i", "want", "to", "drink", "water"};
		
//		TestCase2
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(cards1, cards2, goal));
	}

}

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cntCards1 = 0;
        int cntCards2 = 0;
        for(String word : goal){
            if(word.equals(cards1[cntCards1])){
                if(cntCards1 < cards1.length-1)
                    cntCards1++;
            }else if(word.equals(cards2[cntCards2])){
                if(cntCards2 < cards2.length-1)
                    cntCards2++;
            }else{
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
