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
 * @Date: 2020/10/31 19:32
 * @Version: 1.0
 */

//题目更新
public class QuestionUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao = new QuestionDao();
        int result = 0;
        PrintWriter out = null;
        //1.[调用请求对象]读取【请求头】参数（用户编号）
        Integer questionId = Integer.valueOf(request.getParameter("questionId").trim());
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");

        Questions questions = new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
        //2.[调用DAO]将信息传入填充到update命令并发送到数据库服务器
        result = dao.update(questions);
        //3.[调用响应对象]将处理结果以二进制写入到响应体，交给浏览器

        if(result == 1){
            request.setAttribute("info","试题信息更新成功");
        }else{
            request.setAttribute("info","试题信息更新失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
