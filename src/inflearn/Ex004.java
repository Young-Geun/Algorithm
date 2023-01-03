package inflearn;

import java.util.Scanner;

public class Ex004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());

        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextLine();
        }

        solution(num, arr);
        solution2(num, arr);
        solution3(num, arr);
    }

    public static void solution(int num, String[] arr) {
        for (int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer(arr[i]);
            System.out.println(sb.reverse());
        }
    }

    public static void solution2(int num, String[] arr) {
        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            System.out.println(sb.reverse());
        }
    }

    public static void solution3(int num, String[] arr) {
        for (int i = 0; i < num; i++) {
            int lt = 0;
            int rt = arr[i].length() - 1;

            char[] ch = arr[i].toCharArray();
            while (lt < rt) {
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
                lt++;
                rt--;
            }

            System.out.println(String.valueOf(ch));
        }
    }

}
