package inflearn.lecture01.ex06;

import java.util.Scanner;

public class Ex06_03_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(n, arr);
    }

    public static void solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = tmp; // j 포문이 멈춘 다음 칸에 기준값(=arr[i]) 삽입
        }

        // print
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}