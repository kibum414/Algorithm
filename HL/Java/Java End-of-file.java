import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int i = 1;

        while (scan.hasNext()) {
            sb.append(i++).append(" ").append(scan.nextLine()).append("\n");
        }
        
        System.out.println(sb);

    }

}
