package com.jc.logincase;

import com.sun.javaws.progress.PreloaderPostEventListener;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/valideCodeServlet")
public class ValideCodeServlet extends HttpServlet {

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.画图片
        int imageWidth = 400;
        int imageHeight = 200;
        BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics2D graphics = (Graphics2D) img.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        //2.2画矩形边框
        graphics.setColor(Color.BLUE);
        graphics.setStroke(new BasicStroke(4.5f));
        graphics.drawRect(0, 0, imageWidth - 1, imageHeight - 1);
        //2.3画文字
        StringBuilder sb = new StringBuilder();
        graphics.setFont(new Font("宋体", Font.ITALIC, 80));
        for (int i = 1; i <= 4; i++) {
            int index = new Random().nextInt(chars.length());
            char ch = chars.charAt(index);
            sb.append(ch);
            graphics.drawString(ch + "", imageWidth * i / 6, imageHeight * 2 / 3);
        }
        //将验证码保存到session中
        request.getSession().setAttribute("checkCode",sb.toString());
        //2.4画干扰线
        graphics.setStroke(new BasicStroke(1.5f));
        for (int i = 0; i < 25; i++) {
            graphics.drawLine(new Random().nextInt(imageWidth), new Random().nextInt(imageHeight), new Random().nextInt(imageWidth), new Random().nextInt(imageHeight));
        }

        //输出图片
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
