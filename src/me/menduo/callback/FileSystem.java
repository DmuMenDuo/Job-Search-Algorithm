package me.menduo.callback;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-05-07 12:08
 **/
public class FileSystem {
    private Map<String, Integer> pathMap;
    private Map<String,CallBackFunction> map;

    public FileSystem() {
        pathMap = new HashMap<>();
        map = new HashMap<>();
        pathMap.put("",0);
    }

    public boolean create(String path, Integer value){
        int index = path.lastIndexOf("/");
        String prefix = path.substring(0,index);
        if(pathMap.containsKey(prefix)) {
            pathMap.put(path,value);
            String curPath = path;
            while (curPath.length()>0){
                if(map.containsKey(curPath)) {
                    map.get(curPath).callback();
                }
                int last = curPath.lastIndexOf("/");
                curPath = curPath.substring(0,last);
            }
            return true;
        }
        return false;
    }

    public int get(String path) {
        if(pathMap.containsKey(path)) {
            int result = pathMap.get(path);
            return result;
        }
        return -1;
    }

    public void watch(String file,CallBackFunction callBackFunction) {
        map.put(file,callBackFunction);
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        System.out.println(fileSystem.create("/a",1));
        System.out.println(fileSystem.get("/a"));
        fileSystem.watch("/a/b", () -> System.out.println("no"));
        System.out.println(fileSystem.create("/a/b", 2));
//        System.out.println(fileSystem.get("/a/b"));
//        System.out.println(fileSystem.create("/c/d", 1));
//        System.out.println(fileSystem.get("/c"));
//        //System.out.println(fileSystem.watch("/a",() -> System.out.println("yes")));
//        System.out.println(fileSystem.create("/a/b/c", 3));

    }
}
