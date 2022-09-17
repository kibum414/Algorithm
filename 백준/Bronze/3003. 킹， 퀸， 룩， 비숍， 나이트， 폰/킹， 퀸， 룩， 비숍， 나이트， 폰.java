import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int KING = 1;
    static final int QUEEN = 1;
    static final int ROOK = 2;
    static final int BISHOP = 2;
    static final int KNIGHT = 2;
    static final int PAWN = 8;
    static int king, queen, rook, bishop, knight, pawn;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = Integer.parseInt(st.nextToken());
        queen = Integer.parseInt(st.nextToken());
        rook = Integer.parseInt(st.nextToken());
        bishop = Integer.parseInt(st.nextToken());
        knight = Integer.parseInt(st.nextToken());
        pawn = Integer.parseInt(st.nextToken());

        System.out.println((KING - king) + " " + (QUEEN - queen) + " " + (ROOK - rook) + " " + (BISHOP - bishop) + " " + (KNIGHT - knight) + " " + (PAWN - pawn));

    }

}