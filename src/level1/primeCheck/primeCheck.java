package level1.primeCheck;

import java.util.*;

/**
 * 소수 만들기
 * @author kilhyeongyeong
 *
 */
public class primeCheck {

	public static void main(String[] args) {
//		TestCase1
//		int[] nums = {1,2,3,4};
		
//		TestCase2
		int[] nums = {1,2,7,6,4};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(nums));
	}

}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 0. 에라토스테네스의 채 - 소수 구하기
        int n = 3000;
        boolean[] b = new boolean[n+1];
        b[0] = b[1] = true;
        
        for(int i=2; i*i<=n; i++){
            for(int j=i*i; j<=n; j+=i){
                if(!b[j]) b[j] = true;
            }
        }
        
        // 1. 홀수 짝수 나누기
        List<Integer> even = new ArrayList<>();
        List<Integer> odd  = new ArrayList<>();
        for(int i : nums){
            if(i % 2 == 0) even.add(i);
            else odd.add(i);
        }
        
        // 2. 짝수들 중 nC2 구하기(원소 2개 선택하여 합)
        List<Integer> evenSum = new ArrayList<>();
        for(int i=0; i<even.size(); i++){
            for(int j=i+1; j<even.size(); j++){
                evenSum.add(even.get(i) + even.get(j));        
            }
        }
        
        // 홀 + 짝 + 짝 - 소수 판별하기
        for(int i=0; i<odd.size(); i++){
            for(int j=0; j<evenSum.size(); j++){
                int sum = odd.get(i) + evenSum.get(j);
                if(!b[sum]) answer++;
            }
        }
        
        // 홀 + 홀 + 홀 - 소수 판별하기
        for(int i=0; i<odd.size(); i++){
            for(int j=i+1; j<odd.size(); j++){
                for(int k=j+1; k<odd.size(); k++){
                    int sum = odd.get(i) + odd.get(j) + odd.get(k);
                    if(!b[sum]) answer++;
                }
            }
        }

        return answer;
    }
}
