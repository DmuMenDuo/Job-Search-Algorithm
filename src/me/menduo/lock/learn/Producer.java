package me.menduo.lock.learn;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-11 13:52
 **/
public class Producer {
    private Model model;

    public Producer(Model model) {
        this.model = model;
    }

    public void produce(final String x) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    model.produce(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }


}
