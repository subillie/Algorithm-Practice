// 2058 자릿수 더하기
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
    int sum = 0;
    while (n > 0) {
    	sum += n % 10;  // 일의 자리 더하기
        n /= 10;  // 마지막 자리 제거
    }
    System.out.println(sum);

    sc.close();
	}
}