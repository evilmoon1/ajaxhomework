package com.xzk.web;

import com.xzk.service.MessageService;
import com.xzk.service.MessageServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @description:
 * @date:created in 2020-08-11 19:07
 * @author:Dylan
 * @modified by:
 */
@WebServlet(value = "/message")
public class MessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String reviews = req.getParameter("reviews");

        //2.调取service方法
        MessageService messageService = new MessageServiceImpl();
        List<String> review = messageService.review(reviews);

       //3.将对象返回给客户端，需要转换json格式
        JSONObject jsonObject = JSONObject.fromObject(review);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);
    }
}
