package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/7
 */
public class Question43 {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * <p>
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= num1.length, num2.length <= 200
     * num1 和 num2 只能由数字组成。
     * num1 和 num2 都不包含任何前导零，除了数字0本身。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String multiply(String num1, String num2) {
        // 此方法存在数值溢出问题
        // TODO
        Long res = 0L;

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int xLength = num1.length();
        int yLength = num2.length();
        for (int i = 0; i < xLength; i++) {
            long x = (num1.charAt(xLength - i - 1) - '0') * (long) Math.pow(10, i);
            for (int j = 0; j < yLength; j++) {
                long y = (num2.charAt(yLength - j - 1) - '0') * (long) Math.pow(10, j);
                res += x * y;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Question43 test = new Question43();

        System.out.println(test.multiply("498828660196",
                "840477629533"));

    }
}
