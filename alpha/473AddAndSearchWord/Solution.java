class Word {
    char c;
    boolean hasWord;
    Map<Character, Word> children = new HashMap<>();
    public Word() {

    }
    public Word(char c) {
        this.c = c;
        this.hasWord = false;
    }
}

public class WordDictionary {

    Word root;

    public WordDictionary() {
        root = new Word();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word != null || word.length() != 0) {
            int index = 0;
            Word current = root;
            while (index < word.length()) {
                char c = word.charAt(index);
                Word next = current.children.get(c);
                if (next == null) {
                    current.children.put(c, new Word(c));
                }
                index++;
                current = current.children.get(c);
            }
            current.hasWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word, Word current, int index) {
        if (index == word.length()) {
            return current.hasWord;
        }
        while (index < word.length()) {
            char c = word.charAt(index);
            if (c == '.') {
                for (Map.Entry<Character, Word> entry : current.children.entrySet()) {
                    Word next = entry.getValue();
                    if (search(word, next, index + 1))
                        return true;
                }
                return false;
            } else {
                if (!current.children.containsKey(c))
                    return false;
                index++;
                current = current.children.get(c);
            }
        }
        if (current.hasWord)
            return true;
        return false;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        return search(word, root, 0);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");