package inflearn.lecture02.ex01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex01_06 {

    public static void main(String[] args) {
        // CASE 1.
        System.out.println(
                solution(
                        new int[][]{
                                {10, 20, 30},
                                {12, 15, 20},
                                {20, 12, 15},
                                {15, 20, 10},
                                {10, 15, 10}
                        }
                )
        ); // 58

        // CASE 2.
        System.out.println(
                solution(
                        new int[][]{
                                {10, 9, 11},
                                {15, 20, 25}
                        }
                )
        ); // 24

        // CASE 3.
        System.out.println(
                solution(
                        new int[][]{
                                {0, 3, 27},
                                {20, 5, 5},
                                {19, 5, 6},
                                {10, 10, 10},
                                {15, 10, 5},
                                {3, 7, 20}
                        }
                )
        ); // 32

        // CASE 4.
        System.out.println(
                solution(
                        new int[][]{
                                {3, 7, 20},
                                {10, 15, 5},
                                {19, 5, 6},
                                {10, 10, 10},
                                {15, 10, 5},
                                {3, 7, 20},
                                {12, 12, 6},
                                {10, 20, 0},
                                {5, 10, 15}
                        }
                )
        ); // 48
    }

    public static int solution(int[][] fruit) {
        int answer = 0;
        int[] changeStatusArr = new int[fruit.length]; // 교환한 학생인지 체크하는 플래그(0=교환안함, 1=교환함)

        for (int i = 0; i < fruit.length; i++) {
            // 가장 작은 바구니가 오직 1개인지 확인
            if (isExistDup(fruit[i])) {
                continue;
            }

            // 가장 적은 과일 바구니 찾기
            int minIdx = 0; // 기준이 되는 학생이 가지고 있는 바구니 중 작은 바구니의 idx(0=사과 / 1=배 / 2=귤)
            int minValue = Integer.MAX_VALUE; // 가장 적게 들은 바구니에 들어있는 과일의 갯수
            for (int j = 0; j < 3; j++) {
                if (fruit[i][j] < minValue) {
                    minIdx = j;
                    minValue = fruit[i][j];
                }
            }

            // 다른 학생과 비교
            for (int j = 0; j < fruit.length; j++) {
                // 자기 자신과의 비교는 제외
                if (i == j) {
                    continue;
                }

                // 가장 작은 바구니가 오직 1개인지 확인
                if (isExistDup(fruit[j])) {
                    continue;
                }

                // 다른 학생의 가장 적은 과일 바구니 찾기
                int minIdx2 = 0;
                int minValue2 = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (fruit[j][k] < minValue2) {
                        minIdx2 = k;
                        minValue2 = fruit[j][k];
                    }
                }

                // 교환
                if (fruit[i][minIdx] + 1 <= fruit[j][minIdx] - 1 &&
                        fruit[j][minIdx2] + 1 <= fruit[i][minIdx2] - 1 &&
                        changeStatusArr[i] == 0 && changeStatusArr[j] == 0) {
                    fruit[i][minIdx]++;
                    fruit[i][minIdx2]--;
                    fruit[j][minIdx]--;
                    fruit[j][minIdx2]++;
                    changeStatusArr[i] = 1;
                    changeStatusArr[j] = 1;
                }

                // System.out.println(Arrays.deepToString(fruit));
            }
        }

        for (int[] arr : fruit) {
            answer += Arrays.stream(arr).min().getAsInt();
        }

        return answer;
    }

    public static boolean isExistDup(int[] fruit) {
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(fruit).boxed().toArray(Integer[]::new)));
        return set.size() != fruit.length;
    }

}
