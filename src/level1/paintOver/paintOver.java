package level1.paintOver;

/**
 * 덧칠하기
 * @author kilhyeongyeong
 *
 */
public class paintOver {

	public static void main(String[] args) {
//		TestCase1
//		int n = 8;
//		int m = 4;
//		int[] section = {2, 3, 6};
		
//		TestCase2
//		int n = 5;
//		int m = 4;
//		int[] section = {1, 3};
		
//		TestCase3
		int n = 4;
		int m = 1;
		int[] section = {1, 2, 3, 4};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(n, m, section));
	}

}

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int min = 0;
        int max = 0;
        
        for(int sec : section){
            if(sec > max){
                min = sec;
                max = min + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}
