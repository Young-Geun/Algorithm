package inflearn.lecture02;

public class Ex09_03_Answer {

    public static void main(String[] args) {
        // 해설코드인데 오류 발생...
        System.out.println(solution(6, new int[]{10, 20, 15, 25, 10, 20})); // 75
    }

    public static int solution(int n, int[] score) {
        int[] dy = new int[n + 1];
        dy[1] = score[1];
        if (n > 1) dy[2] = score[1] + score[2];
        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 2] + score[i], dy[i - 3] + score[i - 1] + score[i]);
        }
        return dy[n];
    }

}