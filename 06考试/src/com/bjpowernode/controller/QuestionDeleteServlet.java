package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: EdwardX
 * @Description: ${description}
 * @Date: 2020/10/31 9:18
 * @Version: 1.0
 */
public class QuestionDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        QuestionDao dao = new QuestionDao();
        int result = 0;
        PrintWriter out = null;
        //1.[调用请求对象]读取【请求头】参数（用户编号）
        questionId = request.getParameter("questionId");
        //2.[调用DAO]将用户编号填充到delete命令并发送到数据库服务器
        result = dao.delete(questionId);
        //3.[调用响应对象]将处理结果以二进制写入到响应体，交给浏览器

        if(result == 1){
            request.setAttribute("info","试题信息删除成功");
        }else{
            request.setAttribute("info","试题信息删除失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
