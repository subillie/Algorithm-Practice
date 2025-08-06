// 1936 1대1 가위바위보
import java.util.Scanner;

public class d1_1936 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        if ((A == 1 && B == 2) || (A == 2 && B == 3) || (A == 3 && B == 1)){
            System.out.println("B");
        } else {
            System.out.println("A");
        }
        
        sc.close();
    }
}
