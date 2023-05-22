package level1.practiceTest;

import java.util.*;

/**
 * 모의고사
 * @author KIS_Gal.Book2
 *
 */
public class practiceTest {

	public static void main(String[] args) {
//		TestCase1
//		int[] answers = {1,2,3,4,5};
		
//		TestCase2
		int[] answers = {1,3,2,4,2};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(answers)));
	}

}

class Solution {
    public int[] solution(int[] answers) {
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++){
            // 1번 학생
            if(answers[i] == student1[i%student1.length]) score[0]++;
            // 2번 학생
            if(answers[i] == student2[i%student2.length]) score[1]++;
            // 3번 학생
            if(answers[i] == student3[i%student3.length]) score[2]++;
        }
        
        // 최댓값 구하기
        int max = 0;
        for(int i=1; i<score.length; i++){
            int m = Math.max(score[i-1], score[i]);
            max = (max < m) ? m : max;
        }
        
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(max == score[i]) answerList.add(i+1);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
