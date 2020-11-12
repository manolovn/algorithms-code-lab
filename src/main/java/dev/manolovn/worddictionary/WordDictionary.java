package dev.manolovn.worddictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * difficulty: MEDIUM
 * topic: TRIE
 */
class WordDictionary {

    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = true;
    } // t: O(n) ; s: O(n)

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, trie);
    }

    private boolean search(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else if (c == '.') {
                for (char ch : node.children.keySet()) {
                    TrieNode child = node.children.get(ch);
                    if (search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
        return node.word;
    } // t: O(n*m) ; s: O(n)

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;

        public TrieNode() {
        }
    }
}
