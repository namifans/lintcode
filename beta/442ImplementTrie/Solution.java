/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */


class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
        hasWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        if (word != null || word.length() != 0) {
            int index = 0;
            TrieNode current = root;
            while (index < word.length()) {
                char c = word.charAt(index);
                TrieNode nextNode = current.children.get(c);
                if (nextNode == null) {
                    current.children.put(c, new TrieNode(c));
                }
                index++;
                current = current.children.get(c);
            }
            current.hasWord = true;
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        if (word != null || word.length() != 0) {
            int index = 0;
            TrieNode current = root;
            while (index < word.length()) {
                char c = word.charAt(index);
                if (!current.children.containsKey(c)) {
                    return false;
                }
                index++;
                current = current.children.get(c);
            }
            if (current.hasWord)
                return true;
        }
        return false;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix != null || prefix.length() != 0) {
            int index = 0;
            TrieNode current = root;
            while (index < prefix.length()) {
                char c = prefix.charAt(index);
                if (!current.children.containsKey(c)) {
                    return false;
                }
                index++;
                current = current.children.get(c);
            }
            if (current.c == prefix.charAt(prefix.length() - 1))
                return true;
        }
        return false;
    }
}