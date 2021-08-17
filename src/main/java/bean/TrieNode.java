package bean;

public class TrieNode {

    // 前缀树的节点可能有26个子节点，数组中第1个元素对应'a'的子节点
    public TrieNode children[];
    // 到达该节点的路径对应的字符是否为字典中的一个完整的单词
    public boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
