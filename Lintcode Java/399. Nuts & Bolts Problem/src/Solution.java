public class Solution {
    /**
     * @param nuts:    an array of integers
     * @param bolts:   an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null) {
            return;
        }
        if (nuts.length != bolts.length) {
            return;
        }
        
        quickSort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    
    private void quickSort(String[] nuts, String[] bolts, NBComparator compare, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int part_idx = partition(bolts, nuts[l], compare, l, r);
        partition(nuts, bolts[part_idx], compare, l, r);
        
        quickSort(nuts, bolts, compare, l, part_idx - 1);
        quickSort(nuts, bolts, compare, part_idx + 1, r);
    }
    
    private int partition(String[] str, String pivot, NBComparator compare, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (compare.cmp(pivot, str[i]) == 0 || compare.cmp(str[i], pivot) == 0) {
                String tmp = str[i];
                str[i] = str[l];
                str[l] = tmp;
                break;
            }
        }
        
        int i = l, j = r;
        String s = str[l];
        while (i < j) {
            while (i < j && (compare.cmp(str[j], pivot) == -1 || compare.cmp(pivot, str[j]) == 1)) {
                j--;
            }
            str[i] = str[j];
            while (i < j && (compare.cmp(str[i], pivot) == 1 || compare.cmp(pivot, str[i]) == -1)) {
                i++;
            }
            str[j] = str[i];
        }
        
        str[i] = s;
        return i;
    }
}

interface NBComparator {
    int cmp(String a, String b);
}