package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 */
public class Hot100_62_trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}

// 自己写的
class Trie1 {

    List<String> content;

    public Trie1() {
        content = new ArrayList<>();
    }

    public void insert(String word) {
        content.add(word);
    }

    public boolean search(String word) {
        return content.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String word : content) {
            if (word.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}

// 题解
// 字典树，又称前缀树
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false; // 表示是否为字符串的结尾
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

