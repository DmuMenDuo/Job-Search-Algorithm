package me.menduo.aop;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-17 14:51
 **/
public class FatherProxy implements InvocationHandler {

    private Father target;

    public FatherProxy(Father target) {
        this.target = target;
    }

    private void sayChiLeMa() {
        System.out.println("吃了吗您~");
    }

   public static Father newInstance(Father target) {


        return (Father) Proxy.newProxyInstance(FatherProxy.class.getClassLoader(),new Class[]{Father.class},new FatherProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sayChiLeMa();
        return method.invoke(target,args);
    }
}
