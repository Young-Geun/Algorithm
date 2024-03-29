package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. [1차] 비밀지도 - https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class Ex17681 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))); // ["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}))); // ["######", "### #", "## ##", " #### ", " #####", "### # "]
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i]))).replaceAll("0", " ").replaceAll("1", "#");
        }
        return answer;
    }

}
