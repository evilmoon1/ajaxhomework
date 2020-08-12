package com.xzk.web;

import com.xzk.service.MessageService;
import com.xzk.service.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @date:created in 2020-08-11 21:57
 * @author:Dylan
 * @modified by:
 */
@WebServlet(value = "/likeplus")
public class LikeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String num = req.getParameter("num");
        //count解析成整数
        int i = Integer.parseInt(num);
        //2.调取service方法
        MessageService messageService = new MessageServiceImpl();
        int num1 = messageService.count(i);
        System.out.println(num1);
        PrintWriter writer = resp.getWriter();
        //验证 注意:ajax请求处理完毕后，返回数据时使用PrintWriter输出流，且ajax默认返回原页面
        writer.print(num1);
    }
}
