package me.menduo.leetcode;

import me.menduo.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-18 20:12
 **/
public class TrieNode {
    private char value;
    private int wordCount;
    private Map<Integer, TreeNode> map = new HashMap<>();
    private boolean isTail = false;
}
