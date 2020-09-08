package com.jc;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, MyException, UnsupportedEncodingException, ParseException {
        //1.Collection
//        Collection<String> col = new ArrayList<>();
//        col.add("ac");
//        col.add("da");
//        col.add("da");
//        col.add("cc");
//        iterout(col);
//        col.remove("ac");
//        iterout(col);
//        boolean da = col.contains("da");
//        System.out.println(da);
//        col.clear();
//        iterout(col);
        //2.List
//        List<String> list = new ArrayList<>();
//        list.add("as");
//        list.add("cc");
//        list.add("vv");
//        Iterator<String> iterator = list.iterator();
//        System.out.println("--------第一种遍历方式:iterator迭代器----------");
//        while(iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//        }
//        System.out.println("---------第二种遍历方式:普通for----------");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("---------第三种遍历方式:增强for-----------");
//        for (String item:list) {
//            System.out.println(item);
//        }

        //3.set
//        Set<String> set = new HashSet<>();
//        set.add("aas");
//        set.add("ff");
//        set.add("aas");
//        for (String item: set) {
//
//            System.out.println(item);
//
//        }
        //4.map
//        Map<String,Integer> map = new HashMap<>();
//        map.put("a",1);
//        map.put("b",23);
//        map.put("c",3);
//        Set<String> keys = map.keySet();
//        for (String key: keys) {
//
//            System.out.println(key+":"+map.get(key));
//
//        }
//
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String,Integer> item: entries) {
//
//            String key = item.getKey();
//            Integer value = item.getValue();
//
//            System.out.println(key+":"+value);
//
//        }
//
//        Class math = Class.forName("java.lang.Math");
//        Constructor cons = math.getDeclaredConstructor();
//        cons.setAccessible(true);
//        Object obj = cons.newInstance();
//        Method abs = math.getMethod("sqrt",double.class);
//        Object invoke = abs.invoke(obj, -9);
//        System.out.println(invoke);
//        Field fi = math.getDeclaredField("twoToTheDoubleScaleDown");
//        fi.setAccessible(true);
//        Object o = fi.get(obj);
//        System.out.println(o);

//        throw new MyException("自定义异常");

//        throw new MyRuntimeException("运行期异常");

//        String str = "         232 sds我 gtsf              ";
//        char c = str.charAt(4);
//        System.out.println(c);
//        String ccc = str.concat("ccc");
//        System.out.println(ccc);
//        boolean sd = str.contains("sd");
//        System.out.println(sd);
//        boolean sf = str.endsWith("sf");
//        System.out.println(sf);
//        boolean b1 = str.startsWith("232");
//        System.out.println(b1);
//        boolean b = str.equalsIgnoreCase("232 sds fd4t gtSF");
//        System.out.println(b);
//        byte[] bytes = str.getBytes("utf-8");
//        for (byte item: bytes) {
//            System.out.println(item);
//        }
//        int i = str.indexOf("我");
//        System.out.println(i);
//        boolean empty = str.isEmpty();
//        System.out.println(empty);
//        int s = str.lastIndexOf("s");
//        System.out.println(s);
//        int length = str.length();
//        System.out.println(length);
//        boolean dfsf = str.matches("dfsf");
//        System.out.println(dfsf);
//        String cc = str.replace("232", "cc");
//        System.out.println(cc);
//        String[] s1 = str.split(" ");
//        for (String item:s1) {
//            System.out.println(item);
//        }
//        String substring = str.substring(1, 3);
//        System.out.println(substring);
//        char[] chars = str.toCharArray();
//        for (int j = 0; j < chars.length; j++) {
//            System.out.println(chars[j]);
//        }
//        String s2 = str.toUpperCase();
//        System.out.println(s2);
//        String trim = str.trim();
//        System.out.println(trim);
//        StringBuilder sb = new StringBuilder();
//        String string = sb.append(22).append("cc").append(2.2).append('v').toString();
//        System.out.println(string);
//        StringBuffer sbf = new StringBuffer();
//        String string1 = sbf.append(2).append('v').append(33.33).append("ccd").toString();
//        System.out.println(string1);
//
//        Date dt = new Date();
//        Date dt1 = (Date) dt.clone();
//        System.out.println(dt.getTime());
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = df.format(dt);
//        System.out.println(format);
//
//        Date parse = df.parse("2020-08-15 17:20:37");
//        System.out.println(parse);
//
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.ERA));
//
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        int[] ss = new int[]{12,34,34,6,64,37,87,35,66};
//        int[] dd = new int[]{1,3,4,5,6,8,7,8,9,0,3,1,2,3,5,7,8};
//        System.arraycopy(ss,0,dd,0,ss.length);
//        for (int j = 0; j < dd.length; j++) {
//            System.out.print(dd[j]+" ");
//        }
//
//        System.out.println();
//
//        Arrays.sort(ss);
//
//        for (int it:ss) {
//            System.out.print(it+" ");
//        }
//        for (int j = ss.length-1; j >=0 ; j--) {
//            System.out.print(ss[j]+" ");
//        }
//
//        System.out.println();
//        int i1 = Arrays.binarySearch(ss, 3);
//        System.out.println(i1);
//
//        Scanner sc = new Scanner(System.in);
//        int i2 = sc.nextInt();
//        System.out.println(i2);
//
//        Random rd = new Random();
//        for (int j = 0; j < 100; j++) {
//            System.out.println(rd.nextInt(10));
//        }
//        double ceil = Math.ceil(3.4);
//        double floor = Math.floor(3.3);
//        System.out.println(ceil);
//        System.out.println(floor);
//        System.out.println(Math.round(3.5));
//        System.out.println(Math.log10(100));

//        String st = "10735as87966qq55co99mo";

//        System.out.println(st instanceof String);
//        boolean matches = st.matches("^\\d+@[a-zA-Z]{2}\\.com$");
//        System.out.println(matches);
//        String[] split = st.split("[a-zA-Z]{2}");
//        for (String item:split) {
//            System.out.println(item);
//        }
//        String ccc = st.replaceAll("\\d+", "ccc");
////        System.out.println(ccc);
//        String $ = "ddddwwr42r2w";
//        char c = $.charAt(3);
//        System.out.println(c);
        


    }
    private static void iterout(Collection<String> col){

        Iterator<String> iterator = col.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
