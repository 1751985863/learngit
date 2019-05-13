import java.util.InputMismatchException;
import java.util.Scanner;

 class WeekTwoExe {

    public static void main(String[] args) {

        /* step1. 验证 3^3 + 4^3 + 5^3 = 6^3 */
        long x = getCube(3) + getCube(4) + getCube(5);
        long y = getCube(6);
        if (x == y) {
            System.out.println("3^3 + 4^3 + 5^3 = 6^3");
        } else {
            System.out.println("3^3 + 4^3 + 5^3 != 6^3");
        }

        /* step2. 验证 6^3 + 7^3 + ... + 69^3 = 180^3 */
        int i = 0;
        long total = 0;

        for (i = 6; i < 70; i++) {
            total += getCube(i);
        }

        if (total == getCube(180)) {
            System.out.println("6^3 + 7^3 + ... + 69^3 = 180^3");
        } else {
            System.out.println("6^3 + 7^3 + ... + 69^3 != 180^3");
        }

        /* step3. 在小于输入的数字中间，找出符合题目条件的数字 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("input an integer:");
        int maxNum = scanner.nextInt();
        long[] result = new long[maxNum];
        long[] sum = new long[maxNum];

        //result[]数组存放结果
        for (i = 0; i < maxNum; i++) {
            result[i] = getCube(i);
            sum[i] = result[i];
        }

        int len = 0;
        int start = 0;
        long leftTotal = 0;
        int resultPos = 0;
        int sumPos = 0;
        //假设至少有连续三个数字之和才能满足题设条件
        for (len = 3; len < maxNum; len++) {

            for (start = 0; start < maxNum; start++) {

                leftTotal = 0;

                //防止数组访问越界
                if (start + len > maxNum) {
                    break;
                }

                for (sumPos = start; sumPos < start + len; sumPos++) {
                    leftTotal += sum[sumPos];
                }

                for (resultPos = 0; resultPos < maxNum; resultPos++) {
                    if (leftTotal == result[resultPos]) {
                        System.out.printf("%d^3 + %d^3 + ... + %d^3 = %d^3\n",
                                start, start + 1, start + len - 1, resultPos);
                    }
                }
            }
        }
    }


    static long getCube(int num) {
        if (num < 0) {
            System.out.println("ERROR: INVALID NUMBER!");
            return -1;
        }
        return (num * num * num);
    }

}