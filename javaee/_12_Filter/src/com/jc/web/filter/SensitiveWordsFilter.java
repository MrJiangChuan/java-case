package com.jc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词过滤
 */
@WebFilter("/*")
//@WebFilter("/home.jsp")
//@WebFilter("/user/*")
//@WebFilter("*.jsp")
public class SensitiveWordsFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
//        System.out.println("filter init...");
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //对getParamter方法进行增强
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if (method.getName().equals("getParameter")) {

                    String result = (String) method.invoke(request, args);

                    if (result == null) return null;

                    //获取敏感词文件
                    String realPath = request.getServletContext().getRealPath("/WEB-INF/classes/敏感词.txt");
                    List<String> list = readSensitiveWords(realPath);
                    System.out.println(list);
                    for (String s : list) {
                        if (result.contains(s)) {
                            //替换敏感词
                            result = result.replace(s, "***");
                        }
                    }
                    return result;
                } else {
                    return method.invoke(request, args);
                }
            }
        });
        chain.doFilter(proxyRequest, resp);

    }

    public void destroy() {
//        System.out.println("filter destroy...");
    }

    /**
     * 读取敏感词内容
     *
     * @param path 敏感词文件路径
     * @return 存放敏感词列表项
     */
    private List<String> readSensitiveWords(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
        List<String> list = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            list.add(str);
        }
        bufferedReader.close();
        return list;
    }

}
