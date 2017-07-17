public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        
        if (image == null && image.length == 0)
            return -1;
        if (image[0] == null && image[0].length == 0)
            return -1;
        int n = image.length;
        int m = image[0].length;
        int left = searchLeft(image, 0, y);
        int right = searchRight(image, y, m - 1);
        int top = searchTop(image, 0, x);
        int bot = searchBot(image, x, n - 1);
        return (right - left + 1) * (bot - top + 1);
    }

    private int searchLeft(char[][] image, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (searchRow(image, mid))
                right = mid - 1;
            else 
                left = mid + 1;
        }   
        return left;
    }

    private int searchRight(char[][] image, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (searchRow(image, mid))
                left = mid + 1;
            else 
                right = mid - 1;
        }   
        return right;
    }    

    private int searchTop(char[][] image, int top, int bot) {
        while (top <= bot) {
            int mid = top + (bot - top) / 2;
            if (searchCol(image, mid))
                bot = mid - 1;
            else 
                top = mid + 1;
        }   
        return top;
    }   

    private int searchBot(char[][] image, int top, int bot) {
        while (top <= bot) {
            int mid = top + (bot - top) / 2;
            if (searchCol(image, mid))
                top = mid + 1;
            else 
                bot = mid - 1;
        }   
        return bot;
    }    
 

    private boolean searchRow(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1')
                return true;
        }
        return false;
    }

    private boolean searchCol(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1')
                return true;
        }
        return false;
    }
}