/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    char[] buffer = new char[4];

    public int read(char[] buf, int n) {
        int total = 0;
        char[] tmp = new char[4];
        boolean eof = false;
        for (int i = 0; i < 4; i++) {
            if (buffer[i] != '\0') {
                buf[total++] = buffer[i];
                buffer[i] = '\0';
            }
        }
        while (total < n && ! eof) {
            int read = read4(tmp);
            if (read < 4)
                eof = true;
            int count = Math.min(read, n - total);
            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
            for (int i = 0; i < read - count; i++) {
                buffer[i] = tmp[count + i];
            }
        }
        return total;
    }
}