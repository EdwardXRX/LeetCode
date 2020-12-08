package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: EdwardX
 * @Description: ${description}
 * @Date: 2020/10/31 14:54
 * @Version: 1.0
 */
public class QuestionOneInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        QuestionDao dao = new QuestionDao();
        Questions oneQuestion = null;
        PrintWriter out = null;
        //1.[调用请求对象]读取【请求头】参数（用户编号）
        questionId = request.getParameter("questionId");
        //2.[调用DAO]将用户编号填充到delete命令并发送到数据库服务器
        List questionList = new ArrayList();
        questionList = dao.findById(questionId);
        //3.[调用响应对象]将处理结果以二进制写入到响应体，交给浏览器

        if(questionList.isEmpty())
        {
            request.setAttribute("info","无此编号试题");
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("list",questionList);
            request.getRequestDispatcher("/question_show_one.jsp").forward(request,response);
        }

    }
}
