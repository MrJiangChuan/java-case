package com.jc.response;

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

/**
 * 输出验证码
 */
@WebServlet("/code")
public class ResponseDemo3 extends HttpServlet {

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.画图片
        int width = 400;
        int height = 200;
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics2D graphics = (Graphics2D)img.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
        //2.2画矩形边框
        graphics.setColor(Color.BLUE);
        graphics.setStroke(new BasicStroke(4.5f));
        graphics.drawRect(0,0,width-1,height-1);
        //2.3画文字
        graphics.setFont(new Font("宋体",Font.ITALIC,80));
        for (int i = 1; i <= 4; i++) {
            int index = new Random().nextInt(chars.length());
            char ch = chars.charAt(index);
            graphics.drawString(ch+"",width*i/6,height*2/3);
        }
        //2.4画干扰线
        graphics.setStroke(new BasicStroke(1.5f));
        for (int i = 0; i < 50; i++) {
            graphics.drawLine(new Random().nextInt(width),new Random().nextInt(height),new Random().nextInt(width),new Random().nextInt(height));
        }

        //输出图片
        ImageIO.write(img,"jpg",resp.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
