package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_05_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(solution(num));
    }

    public static int solution(int num) {
        int answer = 0;

        int[] arr = new int[num + 1];
        arr[0] = 1; // 0은 판단에서 제외
        arr[1] = 1; // 1은 판단에서 제외

        for (int i = 2; i <= num; i++) {
            if (arr[i] == 0) {
                answer++;

                // 배수는 모두 1로 만들어서 다음 조건에 만족하지 않도록 만들기
                for (int j = i; j <= num; j += i) {
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

}