import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        // Write your code here
        List<Integer> listOfNum = new ArrayList<>(getDigits(num));
        List<Integer> listOfMaxnum = new ArrayList<>(listOfNum);
        Collections.sort(listOfMaxnum, ((o1, o2) -> o2 - o1));
        int indexSwapMax = listOfNum.size(), indexSwapOrig = 0;
        for (int i = 0; i < listOfNum.size(); i++) {
            if (listOfNum.get(i) != listOfMaxnum.get(i)) {
                indexSwapMax = i;
                break;
            }
        }
        if (indexSwapMax == listOfNum.size()) {
            return num;
        }
        for (int i = listOfNum.size() - 1; i >= 0; i--) {
            if (listOfNum.get(i) == listOfMaxnum.get(indexSwapMax)) {
                indexSwapOrig = i;
                break;
            }
        }
        Collections.swap(listOfNum, indexSwapMax, indexSwapOrig);
        return listToInteger(listOfNum);
    }
    
    public List<Integer> getDigits(int num) {
        List<Integer> list = new ArrayList<>();
        if (num == 0) {
            list.add(0);
            return list;
        }
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }
    
    public int listToInteger(List<Integer> list) {
        int num = 0;
        for (Integer i : list) {
            num *= 10;
            num += i;
        }
        return num;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(9973));
    }
}