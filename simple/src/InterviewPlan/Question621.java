package InterviewPlan;

import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/9/9
 */
public class Question621 {
    /**
     * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * <p>
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * <p>
     * 你需要计算完成所有任务所需要的 最短时间 。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/task-scheduler
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }
        Arrays.sort(cnt);
        int max = cnt[25];
        int maxNum = 0;
        for (int i = 25; i >= 0; i--) {
            if (max == cnt[i]) {
                maxNum++;
            } else {
                break;
            }
        }
        return n * (max - 1) <= tasks.length - max - (maxNum - 1) ? tasks.length : (n + 1) * (max - 1) + maxNum;
    }
}
