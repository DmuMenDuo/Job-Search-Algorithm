package me.menduo.leetcode;

import me.menduo.others.LRUCache;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-06 14:37
 **/
public class NO146LRUCache {
    public static void main(String[] args) {
        LRUCache<Integer,String> lruCache = new LRUCache<>(3);
        lruCache.put(1,"a");
        lruCache.put(2,"b");
        lruCache.put(3,"c");
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(4,"d");
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(4));
    }
}
