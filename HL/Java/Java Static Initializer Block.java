import java.util.*;

public class Solution {

    static Scanner scan = new Scanner(System.in);
    static int B, H;

    static {
        B = scan.nextInt();
        H = scan.nextInt();
    }

    public static void main(String[] args) {

        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");

            return;
        }

        System.out.println(B * H);

    }

}
