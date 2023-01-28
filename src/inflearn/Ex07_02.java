package inflearn;

import java.util.Scanner;

public class Ex07_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    public static void solution(int n) {
        if (n != 0) {
            solution(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

}