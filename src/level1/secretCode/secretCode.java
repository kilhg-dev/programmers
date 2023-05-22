package level1.secretCode;

import java.util.*;

/**
 * 둘만의 암호
 * @author kilhyeongyeong
 *
 */
public class secretCode {

	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		
		Solution sol = new Solution();
		System.out.println(sol.solution(s, skip, index));
	}

}

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Set<Integer> skipUnicode = new HashSet<>();
        for(int i = 0; i <skip. length(); i++){
            skipUnicode. add((int)skip.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            int uniS= (int)s.charAt(i);
            int idxCnt = 0;
            while(idxCnt < index){
                if(uniS + 1 > 122) uniS = 96;
                if(!skipUnicode.contains(uniS + 1)) idxCnt++;
                uniS++; 
            }
            sb. append((char)uniS);
        }
        answer = sb.toString();
        return answer;
    }
}
