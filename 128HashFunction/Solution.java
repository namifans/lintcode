class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0)
            return 0;
        long hash = 0;
        for (int i = 0; i < key.length; i++) {
            hash = hash * 33 + (int) key[i];
            hash %= HASH_SIZE;
        }
        return (int) hash;
    }
};