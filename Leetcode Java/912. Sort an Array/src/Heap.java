import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {7, 5, 4, 3, 2, 0};
        // percolateUp(arr, 5);
        deleteMax(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    // 大顶堆
    private static int percolateUp(int[] arr, int i) {
        int tmp = arr[i];
        while (i > 0) {
            // j 是 i 的父节点
            int j = (i - 1) >> 1;
            // 如果儿子小于等于父亲，不用换
            if (tmp <= arr[j]) {
                break;
            }
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = tmp;
        return i;
    }
    
    private static int deleteMax(int[] arr) {
        int max = arr[0];
        arr[0] = arr[arr.length - 1];
        int tmp = arr[0];
        int i = 0;
        while (2 * i + 1 < arr.length - 1) {
            int lchild = i * 2 + 1;
            int rchild = i * 2 + 2;
            
            int j;
            if (rchild > arr.length - 2) {
                if (tmp >= arr[lchild]) {
                    break;
                }
                j = lchild;
            } else {
                if (tmp >= arr[lchild] && tmp >= arr[rchild]) {
                    break;
                }
                j = arr[lchild] > arr[rchild] ? lchild : rchild;
            }
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = tmp;
        
        return max;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
