package me.menduo.leetcode;




import java.util.List;

import java.util.ArrayList;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-24 13:55
 **/
public class NO212 {
        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = buildTrie(words);
            List<String> result = new ArrayList();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(result, board, i, j, root);
                }
            }
            return result;
        }

        private void dfs(List<String> result, char[][] board, int x, int y, TrieNode root) {
            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
            char c = board[x][y];
            if(c == '#') return;
            if(root.children[c-'a'] == null) return;
            board[x][y] = '#';
            if(root.children[c-'a'].word !=null) {
                result.add(root.children[c-'a'].word);
                root.children[c-'a'].word = null;
            }

            dfs(result,board,x-1,y,root.children[c-'a']);
            dfs(result,board,x+1,y,root.children[c-'a']);
            dfs(result,board,x,y-1,root.children[c-'a']);
            dfs(result,board,x,y+1,root.children[c-'a']);
            board[x][y] = c;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int index;
            String word;
            TrieNode(int index){
                this.index = index;
            }
        }

        private TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode(-1);
            for (int i = 0; i < words.length; i++) {
                TrieNode cur = root;
                char[] chars = words[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (cur.children[chars[j]-'a'] == null)
                        cur.children[chars[j]-'a'] = new TrieNode(chars[j]);
                    cur = cur.children[chars[j]-'a'];
                }
                cur.word = words[i];
            }
            return root;
        }

    public static void main(String[] args) {
        NO212 no212 = new NO212();
        no212.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},new String[]{"oath","pea","eat","rain"});
    }
}
