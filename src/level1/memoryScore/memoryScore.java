package level1.memoryScore;

import java.util.*;

/**
 * 추억 점수
 * @author kilhyeongyeong
 *
 */
public class memoryScore {

	public static void main(String[] args) {
		/*
		 * // TestCase1 
		 * String[] name = {"may", "kein", "kain", "radi"}; 
		 * int[] yearning = {5, 10, 1, 3}; 
		 * String[][] photo = {{"may", "kein", "kain", "radi"}, {"may","kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		 * 
		 */
		
		/*
		 * // TestCase2 
		 * String[] name = {"kali", "mari", "don"}; 
		 * int[] yearning = {11, 1, 55}; 
		 * String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom","teddy"}, {"con", "mona", "don"}};
		 */
		
//		TestCase3
		String[] name = {"may", "kein", "kain", "radi"}; 
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(name, yearning, photo)));
	}

}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameMap = new HashMap<>();
        for(int i=0;i<name.length; i++){
            nameMap.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(String photoName : photo[i]){
                if(!Objects.isNull(nameMap.get(photoName))){
                    sum += nameMap.get(photoName);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
