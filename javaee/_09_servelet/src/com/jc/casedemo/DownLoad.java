package com.jc.casedemo;

import com.jc.utils.DownLoadUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======downLoad=========");
        String filename = req.getParameter("filename");
        String realPath = getServletContext().getRealPath("/img/" + filename);
        String mimeType = getServletContext().getMimeType(filename);
        resp.setContentType(mimeType);
        //设置附件
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //将文件写入浏览器
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] buf = new byte[1024];
        while ((len=fis.read(buf))!=-1){
            os.write(buf,0,len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
