package inflearn.lecture02.ex03;

import java.util.Arrays;

public class Ex03_01 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3})); // 5
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})); // 10
        System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3})); // 1
        System.out.println(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})); // 7
        System.out.println(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})); // 3
        System.out.println(solution(new int[]{-3, -2, -1, -1, 1, 2, 3, 4, 5, 6, 7, 2, 3})); // 7

    }

    public static int solution(int[] nums) {
        int answer = 1;

        // 중복 제거 후 정렬
        int[] distinctSortedNums = Arrays.stream(nums).distinct().sorted().toArray();

        // 기준이 되는 다음 수가 1씩 증가하는 수인지 확인
        for (int i = 0; i < distinctSortedNums.length - 1; i++) {
            int idx = i;
            int count = 1;
            while (idx < distinctSortedNums.length - 1) {
                if (distinctSortedNums[idx + 1] - distinctSortedNums[idx] == 1) {
                    count++;
                } else {
                    break;
                }
                idx++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

}
