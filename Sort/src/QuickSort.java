import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 进行快速排序
        quickSort(arr, 0, n - 1);

        // 打印输出
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) return;

        // 确定分界点
        int p = arr[l];

        // 两个边界
        int i = l - 1, j = r + 1;

        // 调整区间
        while(i<j){
            do i++; while (arr[i]<p);   // 注意这里没有=，有等于会溢出
            do j--; while (arr[j]>p);
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        quickSort(arr,l,j);
        quickSort(arr,j+1,r);
    }
}
