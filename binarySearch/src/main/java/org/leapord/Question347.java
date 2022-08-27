//package org.leapord;
//
///**
// * @author leapord
// * @since 2022/8/1
// */
//public class Question347 {
//    /**
//     * 猜数字游戏的规则如下：
//     *
//     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
//     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
//     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
//     *
//     * -1：我选出的数字比你猜的数字小 pick < num
//     * 1：我选出的数字比你猜的数字大 pick > num
//     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
//     * 返回我选出的数字。
//     *
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode.cn/problems/guess-number-higher-or-lower
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     */
//
//
//    /**
//     * Forward declaration of guess API.
//     *
//     * @param num your guess
//     * @return -1 if num is lower than the guess number
//     * 1 if num is higher than the guess number
//     * otherwise return 0
//     * int guess(int num);
//     */
//    public class Solution extends GuessGame {
//        public int guessNumber(int n) {
//            // 注意题设中定义好 父类，其中含有 guess 方法，此处只需要按照 guess返回结果即可 找到对应的查找，
//            // 此题不是直接二分查找，利用二分查找方式 猜数字
//            int left = 1;
//            int right = n;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (guess(mid) <= 0) { // 数字比猜的要小 ， 答案在[left,mid] 之间
//                    right = mid; // 此处注意，由于判断条件是 <= 及查找范围是左闭右开
//                } else { // 数字比猜的要大，答案在[mid,right] 之间
//                    left = mid + 1;
//                }
//            }
//            return left;
//        }
//    }
//
//}
