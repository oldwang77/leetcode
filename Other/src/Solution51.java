class Solution51{
    public int reversePairs(int[] nums) {
        if(nums.length<=1) return 0;
        return merge(nums,0,nums.length-1);
    }

    public int merge(int[] nums,int left,int right){
        if(left==right) return 0;
        int mid = left + (right-left)/2;
        int l = merge(nums,left,mid);
        int r = merge(nums,mid+1,right);
        int count = 0;
        int k = 0;
        int[] tmp = new int[right-left+1];
        int i = left,j = mid+1;
        while(i<=mid && j <=right){
            if(nums[i]<=nums[j]){
                tmp[k++] = nums[i++];
            }else {
                tmp[k++]=nums[j++];
                // 因为是有序的，如果当前的i满足条件第一个序列大于第二个序列
                // 那么第一个序列的[i,mid-1]全部可以和当前元素构成逆序对
                count+=(mid-i+1);
            }
        }
        while(i<=mid){
            tmp[k++]=nums[i++];
        }
        while(j<=right){
            tmp[k++]=nums[j++];
        }
        int index = 0;
        while(left<=right){
            nums[left++] = tmp[index++];
        }
        return count + l + r;
    }
}