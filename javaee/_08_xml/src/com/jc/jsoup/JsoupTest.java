package com.jc.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupTest {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {

        //1.Jsoup基本使用
        Document document = Jsoup.parse(new File(JsoupTest.class.getClassLoader().getResource("student.xml").getPath()), "utf-8");
//        Element elementById = document.getElementById("1");
//        Element child = elementById.child(0);
//        System.out.println(child.text());
//        Elements names = document.getElementsByTag("name");
//        System.out.println(names.get(0).text());

        //2.select选择器
//        Elements select = document.select("student[id='2'] name");
//        System.out.println(select.get(0));

        //3.Xpath使用
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode: jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("-------------------------");
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name[@id='0']");
        for (JXNode jxNode: jxNodes1) {
            System.out.println(jxNode);
        }

    }
}
