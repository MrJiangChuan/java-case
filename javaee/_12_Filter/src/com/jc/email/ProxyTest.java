package com.jc.email;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 */
public class ProxyTest {

    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();
        Sale proxyObj = (Sale) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sale")){
                    double arg = (double) args[0];
                    String a = (String) method.invoke(lenovo,arg*0.85);
                    return a+"---送一个鼠标垫";
                }else {
                    return method.invoke(lenovo, args);
                }
            }
        });
        System.out.println(proxyObj.sale(18));
        proxyObj.show();
    }
}
