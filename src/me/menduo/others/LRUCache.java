package me.menduo.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-06 12:44
 **/
public class LRUCache<K,V> {
    private int capacity;

    private CacheNode lastNode;
    private CacheNode firstNode;

    private Map<K,CacheNode> caches;

    private class CacheNode {
        private CacheNode pre;
        private CacheNode next;
        private K key;
        private V value;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.caches = new HashMap<>(capacity);
    }

    public void put(K key, V vaule) {
        CacheNode cacheNode = caches.get(key);
        if(cacheNode==null) {
            if(needRemove()){
                caches.remove(lastNode.key);
                rmLast();
            }
            cacheNode = new CacheNode();
            cacheNode.key=key;
        }
        cacheNode.value = vaule;
        mv2first(cacheNode);
        caches.put(key,cacheNode);


    }

    public V get(K key){
        CacheNode cacheNode = caches.get(key);
        if(cacheNode==null){
            return null;
        }
        mv2first(cacheNode);
        return cacheNode.value;
    }

    private boolean needRemove() {
        return caches.size()>=capacity;
    }
    private void mv2first(CacheNode cacheNode){
        if(cacheNode == firstNode) return;

        if(cacheNode.pre!=null) cacheNode.pre.next = cacheNode.next;
        if(cacheNode.next!=null) cacheNode.next.pre = cacheNode.pre;
        if(cacheNode == lastNode) lastNode = lastNode.pre;
        if (firstNode==null || lastNode==null) {
            firstNode = lastNode =cacheNode;
            return;
        }

        cacheNode.next = firstNode;
        firstNode.pre = cacheNode;
        firstNode = cacheNode;
        firstNode.pre = null;

    }

    private void rmLast(){
        if(lastNode !=null) {
            lastNode = lastNode.pre;
            if(lastNode == null){
                firstNode=null;
            }else
                lastNode.next = null;
        }
    }

}
