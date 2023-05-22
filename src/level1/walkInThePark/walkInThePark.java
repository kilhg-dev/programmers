package level1.walkInThePark;

import java.util.*;

/**
 * 공원 산책
 * @author kilhyeongyeong
 *
 */
public class walkInThePark {

	public static void main(String[] args) {
		
//		TestCase1 
//		String[] park = {"SOO","OOO","OOO"}; 
//		String[] routes = {"E 2","S 2","W 1"};
		 
		
//		TestCase2
//		String[] park = {"SOO","OXX","OOO"};
//		String[] routes = {"E 2","S 2","W 1"};
		
//		TestCase3
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(park, routes)));
	}

}

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int x = 0;
        int y = 0;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                }
            }
        }
    
        for(int i=0; i<routes.length; i++){
            int tx = x;
            int ty = y;
            StringTokenizer stk = new StringTokenizer(routes[i]);
            String ewsn = stk.nextToken();
            int distance = Integer.parseInt(stk.nextToken());
        
            for(int d=0; d<distance; d++){
                if("E".equals(ewsn)) ty++;
                else if("W".equals(ewsn)) ty--;
                else if("S".equals(ewsn)) tx++;
                else if("N".equals(ewsn)) tx--;
                
                if(tx<0 || ty>=park[0].length() || ty<0 || tx>=park.length){
                    tx = x;
                    ty = y;
                    break;
                }else {
                    if(park[tx].charAt(ty) == 'X'){
                        tx = x;
                        ty = y;
                        break;
                    }
                }
            }
            x = tx;
            y = ty;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}