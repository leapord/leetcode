package question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2165 {
    /**
     * 给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
     * <p>
     * 返回不含前导零且值最小的重排数字。
     * <p>
     * 注意，重排各位数字后，num 的符号不会改变。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/smallest-value-of-the-rearranged-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * -1015 <= num <= 1015
     */
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean flag = true;
        if (num < 0) {
            flag = false;
            num = -num;
        }
        String numString = String.valueOf(num);
        char[] chars = numString.toCharArray();
        Arrays.sort(chars);
        if (!flag) {
            String value = String.valueOf(chars);
            StringBuilder sb = new StringBuilder(value);
            sb = sb.reverse();
            return -Long.parseLong(sb.toString());
        }
        char head;
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > '0') {
                head = chars[i];
                idx = i;
                break;
            }
        }
        char temp = chars[0];
        chars[0] = chars[idx];
        chars[idx] = temp;
        Arrays.sort(chars, 1, chars.length - 1);
        return Long.parseLong(String.valueOf(chars));
    }

    public static void main(String[] args) {
        Question2165 test = new Question2165();
        long result = test.smallestNumber(310);
        System.out.println(result);
    }
}
