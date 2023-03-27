class Solution {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int len = balls.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int endX = balls[i][0];
            int endY = balls[i][1];
            int a = 0, b = 0;

            if (startX == endX) {
                int minX = Math.min(startX, m - startX);

                a = (int) Math.pow(minX * 2, 2) + (int) Math.pow(endY - startY, 2);

                if (startY < endY) b = (int) Math.pow(startY + endY, 2);
                else b = (int) Math.pow(n - startY + n - endY, 2);

                answer[i] = Math.min(a, b);
            } else if (startY == endY) {
                int minY = Math.min(startY, n - startY);

                a = (int) Math.pow(endX - startX, 2) + (int) Math.pow(minY * 2, 2);

                if (startX < endX) b = (int) Math.pow(startX + endX, 2);
                else b = (int) Math.pow(m - startX + m - endX, 2);

                answer[i] = Math.min(a, b);
            } else {
                a = (int) Math.pow(startX + endX, 2) + (int) Math.pow(startY - endY, 2);
                b = (int) Math.pow(m + (m - startX) - endX, 2) + (int) Math.pow(startY - endY, 2);
                int c = (int) Math.pow(startY + endY, 2) + (int) Math.pow(startX - endX, 2);
                int d = (int) Math.pow(n + (n - startY) - endY, 2) + (int) Math.pow(startX - endX, 2);

                answer[i] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        return answer;

    }

}