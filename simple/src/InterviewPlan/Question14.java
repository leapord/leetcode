package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/7
 */
public class Question14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        for (int i = 1; i < size; i++) {
            int length = Math.min(strs[0].length(), strs[i].length());
            for (int j = 0; j <= length; j++) {
                if (j == length || strs[0].charAt(j) != strs[i].charAt(j)) {
                    strs[0] = strs[0].substring(0, j);
                    break;
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        Question14 test = new Question14();
        String result = test.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(result);
    }
}
