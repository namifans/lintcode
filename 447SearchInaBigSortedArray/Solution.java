/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) < target)
                left = mid;
            else
                right = mid;
        }
        if (reader.get(left) == target)
            return left;
        if (reader.get(right) == target)
            return right;
        return -1;
    }
}