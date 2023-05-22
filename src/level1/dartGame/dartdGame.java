package level1.dartGame;

import java.util.*;

/**
 * [1차]다트 게임
 * @author kilhyeongyeong
 *
 */
public class dartdGame {

	public static void main(String[] args) {
//		TestCase1
//		String dartResult = "1S2D*3T";

//		TestCase2
//		String dartResult = "1D2S#10S";
		
//		TestCase3
//		String dartResult = "";
		
//		TestCase4
//		String dartResult = "";
		
//		TestCase5
//		String dartResult = "1D#2S*3S";
		
//		TestCase6
//		String dartResult = "1T2D3D#";
		
//		TestCase7
		String dartResult = "1D2S3T*";
		
		Solution sol = new Solution();
		System.out.println(sol.solution(dartResult));
	}

}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        // 1. 점수
        String[] score = dartResult.split("[^0-9]");
        List<Integer> scoreList = new ArrayList<>();
        for(String s : score){
            if(!"".equals(s)) scoreList.add(Integer.parseInt(s));
        }
        
        // 2. 보너스 & 옵션
        String[] bop = dartResult.split("[0-9]");
        List<String> bopList = new ArrayList<>();
        for(String s : bop){
            if(!"".equals(s)) bopList.add(s);
        }
        
        // 3. 각각의 점수 구하기
        int[] totalScore = new int[3];
        for(int i=0; i<scoreList.size(); i++){
            // 3-1. 점수^보너스
            int bonus = 0;
            switch(bopList.get(i).charAt(0)){
                case 'S' :
                    bonus = 1;
                    break;
                case 'D' :
                    bonus = 2;
                    break;
                case 'T' :
                    bonus = 3;
                    break;
            }
            totalScore[i] = (int)Math.pow(scoreList.get(i), bonus);
            
            // 3-2.옵션
            if(bopList.get(i).length() == 2){
                if(bopList.get(i).charAt(1) == '*'){
                    if(i > 0) totalScore[i-1] *= 2;
                    totalScore[i] *= 2;
                }else if(bopList.get(i).charAt(1) == '#'){
                    totalScore[i] *= -1;
                }
            }
        }
        
        // 4. 총 합 구하기
        for(int i : totalScore){
            answer += i;
        }
        
        return answer;
    }
}