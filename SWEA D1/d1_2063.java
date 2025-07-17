// 2063 중간값 찾기
import java.util.Scanner;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
    int[] scores = new int[n];
    for (int i = 0; i < n; i++) {
        scores[i] = sc.nextInt();
    }
    Arrays.sort(scores);
    System.out.println(scores[n / 2]);
    
    sc.close();
	}
}