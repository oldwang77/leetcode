public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target > sum) left++;
            else if (target < sum) right--;
            else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
