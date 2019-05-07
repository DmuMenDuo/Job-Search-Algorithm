package me.menduo.callback;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-05-07 12:06
 **/
public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.watch("/a/b/c", () -> System.out.println("hello"));
    }
}
