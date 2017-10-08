public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0)
            return B;
        if (B == null || B.length == 0)
            return A;
        int[] result = new int[A.length + B.length];
        int a = 0, b = 0, i = 0;
        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[i] = A[a];
                a++;
            } else {
                result[i] = B[b];
                b++;
            }
            i++;
        }
        while (a < A.length) {
            result[i++] = A[a++];
        }
        while (b < B.length) {
            result[i++] = B[b++];
        }
        return result;
    }
}