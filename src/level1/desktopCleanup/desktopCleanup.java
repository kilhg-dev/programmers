package level1.desktopCleanup;

import java.util.*;

/**
 * 바탕화면 정리
 * @author kilhyeongyeong
 *
 */
public class desktopCleanup {

	public static void main(String[] args) {
//		TestCase1
//		String[] wallpaper = {".#...", "..#..", "...#."};
		
//		TestCase2
//		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
		
//		TestCase3
//		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		
//		TestCase4
		String[] wallpaper = {"..", "#."};
		
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(wallpaper)));
	}

}

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {50,50,0,0};
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(answer[0]>i) answer[0]=i;
                    if(answer[1]>j) answer[1]=j;
                    if(answer[2]<i) answer[2]=i;
                    if(answer[3]<j) answer[3]=j;
                }
            }
        }
        answer[2] += 1;
        answer[3] += 1;
        return answer;
    }
}
