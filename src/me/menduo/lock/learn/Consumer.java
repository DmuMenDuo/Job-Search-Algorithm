package me.menduo.lock.learn;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-11 13:52
 **/
public class Consumer {
    private Model model;

    public Consumer(Model model) {
        this.model = model;
    }

    public void consume() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(model.consume());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
