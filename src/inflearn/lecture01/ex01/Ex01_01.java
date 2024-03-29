package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char ch = in.nextLine().charAt(0);

        System.out.println(solution(str, ch));
    }

    public static int solution(String str, char ch) {
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(ch))) {
                answer++;
            }
        }

        return answer;
    }

}
