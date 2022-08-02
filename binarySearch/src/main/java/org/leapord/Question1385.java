package org.leapord;

import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/8/2
 */
public class Question1385 {
    /**
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     * <p>
     * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-the-distance-value-between-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num : arr1) {
            int low = num - d;
            int hight = num + d;
            if (!binarySearch(arr2, low, hight)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean binarySearch(int[] arr, int low, int hight) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= low && arr[mid] <= hight) {
                return true;
            } else if (arr[mid] < low) {
                left = mid + 1;
            } else if (arr[mid] > hight) {
                right = mid - 1;
            }
        }
        return false;
    }
}
