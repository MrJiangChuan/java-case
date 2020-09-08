package com.jc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    /**
     * 通过tomcat内置文件上传api实现
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload1")
    public String upload1(HttpServletRequest request) throws Exception {

        String path = request.getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        FileItemIterator itemIterator = servletFileUpload.getItemIterator(request);
        while (itemIterator.hasNext()) {
            FileItemStream next = itemIterator.next();
            if (!next.isFormField()) {
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String filename = uuid + "_" + next.getName();
                InputStream in = next.openStream();
                OutputStream out = new FileOutputStream(new File(path, filename));
                int len;
                byte[] buf = new byte[1024 * 1024 * 10];
                while ((len = in.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();

            }
        }

        return "success";
    }

    /**
     * SpringMVC提供的文件上传方式
     *
     * @param request
     * @param upload
     * @return
     */
    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile upload) throws IOException {

        String path = request.getServletContext().getRealPath("/uploads/");
        File file = new File(path);

        if (!file.exists()) file.mkdirs();

        String filename = UUID.randomUUID().toString().replace("-", "") + "_" + upload.getOriginalFilename();

        upload.transferTo(new File(path, filename));

        return "success";

    }

    /**
     * 跨服务器文件上传
     *
     * @return
     */
    @RequestMapping("/upload3")
    public String upload3(MultipartFile upload) throws IOException {

        String path = "http://localhost:9090/fileServer/uploads/";
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename = upload.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf('.'));
        filename = uuid + new Date().getTime() + suffix;
        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        resource.put(String.class, upload.getBytes());
        return "success";

    }
}
