

public class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count += i == 0 ? 1 : 0;
        }
        
        for (int i = arr.length - 1, j = arr.length - 1 + count; i >= 0; i--, j--) {
            if (j < arr.length) {
                arr[j] = arr[i];
            }
            
            if (arr[i] == 0) {
                j--;
                if (j < arr.length) {
                    arr[j] = 0;
                }
            }
        }
    }
}
