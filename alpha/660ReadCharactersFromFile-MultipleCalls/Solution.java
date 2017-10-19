/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

    Queue<Character> buffer = new LinkedList<>();
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        char[] tmp = new char[4];
        while (total < n && !buffer.isEmpty()) {
            Character c = buffer.poll();
            buf[total++] = c;
        }
        while (total < n && !eof) {
            int read = read4(tmp);
            if (read < 4) {
                eof = true;
            }
            int count = Math.min(read, n - total);
            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
            for (int i = 0; i < read - count; i++) {
                buffer.add(tmp[count + i]);
            }
        }
        return total;
    }
}