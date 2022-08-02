package offer;

public class Offer53 {
    public int search(int[] nums, int target) {
        int count = 0;
        for(int num : nums){
            if(num == target){
                count++;
            }
        }
        return count;
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int cursor = length;
        for(int i = 0 ; i < length;i++){
            if(i != nums[i]) {
                cursor = i;
                break;
            }
        }
        return cursor;
    }
}
