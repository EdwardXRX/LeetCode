package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Questions;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: EdwardX
 * @Description: ${description}
 * @Date: 2020/10/30 10:22
 * @Version: 1.0
 */
public class QuestionFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        PrintWriter out;
        //1[调用DAO]将查询命令推送到数据库服务器上，得到所有用户信息【List】
        List<Questions> questionsList = dao.findAll();
        //2[调用响应对象]将用户信息结合<table>标签命令以二进制形式写入到响应体

        request.setAttribute("questionsList",questionsList);

        request.getRequestDispatcher("/question_show.jsp").forward(request,response);



    }
}
