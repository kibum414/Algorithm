import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String word;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        arr = new int[26];

        for (int i = 0, len = word.length(); i < len; i++) {
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') arr[word.charAt(i) - 'a']++;
            else if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') arr[word.charAt(i) - 'A']++;
        }

        int max = Integer.MIN_VALUE;
        char ch = 0;

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                ch = (char) ('A' + i);
            }
            else if (max == arr[i]) ch = '?';
        }

        System.out.println(ch);

    }

}