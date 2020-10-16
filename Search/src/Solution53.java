public class Solution53 {
    /**
     * 二分法，先确定右边边界，再确定左边边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 寻找右边的端点
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            // 找到右边端点
            // 仔细看看这个小于等于的写法，小于等于还要+1，证明找到的是右边界
            if (nums[mid] <= target) i = mid + 1;
            else if (nums[mid] > target) j = mid - 1;
            else break;
        }
        int right = j;
        //寻找左边的端点
        i = 0;j = nums.length-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            //寻找左边的端点
            // 大于等于还要-1，证明找到的是左边界
            if (nums[mid] >= target) j = mid - 1;
            else if (nums[mid] < target) i = mid + 1;
            else break;
        }
        int left = i;
        return right - left + 1;
    }
}
