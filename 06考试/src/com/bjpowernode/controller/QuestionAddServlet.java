package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Questions;

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
 * @Date: 2020/10/29 20:14
 * @Version: 1.0
 */
public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title,optionA,optionB,optionC,optionD,answer;
        QuestionDao dao = new QuestionDao();

        Questions questions = null;
        int result = 0;

        PrintWriter out = null;
        //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息信息
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

        //2.【调用UserDao】将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
        questions = new Questions(null,title,optionA,optionB,optionC,optionD,answer);
        result =dao.add(questions);

        //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
        if(result ==1){
            request.setAttribute("info","试题添加成功");
        }else{
            request.setAttribute("info","试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
