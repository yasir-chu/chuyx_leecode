package realization.trie;

/**
 * @author yuxiang.chu
 * @date 2022/3/1 14:38
 **/
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        char[] a = {'a','b','c'};
        char[] b = {'a','c','c'};
        char[] c = {'b','c','c'};
        char[] d = {'d','e','f'};
        trie.insert(a);
        trie.insert(b);
        trie.insert(c);
        trie.insert(d);
        System.out.println(trie.query(d));
        char[] f = {'d','e','g'};
        System.out.println(trie.query(f));
    }

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null){
                p.children[index] = new TrieNode(c);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean query(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }


    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }

    }


}
