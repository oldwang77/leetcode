import java.util.ArrayList;

public class MergeSort {
    public void merge(int[] nums,int left,int right){
        if(left>=right) return ;
        int mid = left + (right-left)/2;
        merge(nums,left,mid);
        merge(nums,mid+1,right);

        int[] tmp = new int[right-left+1];
        int i = left, j = mid+1 ,k=0;
        while(i<=mid && j <=right){
            if(nums[i]<nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }
        while(i<=mid) tmp[k++] = nums[i++];
        while(j<=right) tmp[k++] =nums[j++];

        int index=0;
        while(left<=right){
            nums[left++] = tmp[index++];
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = {1,5,4,2,3};
        m.merge(arr, 0, arr.length -1);
        for(int x:arr){
            System.out.println(x);
        }
    }
}
