package offer02;


import bean.TrieNode;

// 剑指 Offer II 062. 实现前缀树
public class Solution62 {

    private TrieNode root;

    public Solution62() {
        root = new TrieNode();
    }

    // 在前缀树中添加一个字符串
    public void insert(String word) {
        // 首先达到前缀树的根节点
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            // 确认是否有一个子节点与单词第一个字符相等，如果没有则创建一个
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            // node前往下一节点
            node = node.children[ch - 'a'];
        }
        // 将最后一个节点置为true
        node.isWord = true;
    }

    // 查找字符串
    public boolean search(String word) {
        // 从root开始查找
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            // 途中遇到node为null，直接返回false
            if (node.children[ch - 'a'] == null)
                return false;
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    // 查找字符串前缀
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            // 途中遇到node为null，直接返回false
            if (node.children[ch - 'a'] == null)
                return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}
