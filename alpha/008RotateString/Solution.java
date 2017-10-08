public class Solution {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;
        if (offset > str.length)
            offset %= str.length;
        reverseArray(str, 0, str.length - offset - 1);
        reverseArray(str, str.length - offset, str.length - 1);
        reverseArray(str, 0, str.length - 1);
    }

    private void reverseArray(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}