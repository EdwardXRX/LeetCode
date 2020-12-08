package com.bjpowernode.dao;

import com.bjpowernode.entity.Questions;
import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: com.bjpowernode.dao
 * @ClassName: QuestionDao
 * @Author: EdwardX
 * @Description:
 * @Date: 2020/10/29 20:23
 * @Version: 1.0
 */
public class QuestionDao {
    private JdbcUtil util = new JdbcUtil();

    public int add(Questions questions) {
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer)" +
                " values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, questions.getTitle());
            ps.setString(2, questions.getOptionA());
            ps.setString(3, questions.getOptionB());
            ps.setString(4, questions.getOptionC());
            ps.setString(5, questions.getOptionD());
            ps.setString(6, questions.getAnswer());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List findAll() {
        String sql = "select * from question";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List questionList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Questions questions1 = new Questions(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(questions1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return questionList;
    }

    public int delete(String questionId) {
        String sql = "delete from question where questionId=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.valueOf(questionId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List findById(String questionId) {
        String sql = "select * from question where questionId = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List questionList = new ArrayList();
        try {
            ps.setInt(1, Integer.valueOf(questionId));
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer questionId1 = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Questions oneQuestion = new Questions(questionId1, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(oneQuestion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return questionList;
    }

    public int update(Questions questions)
    {
        String sql="update question set title=? , optionA=? , optionB=? , optionC=? , optionD=? , answer=? where questionId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, questions.getTitle());
            ps.setString(2, questions.getOptionA());
            ps.setString(3, questions.getOptionB());
            ps.setString(4, questions.getOptionC());
            ps.setString(5, questions.getOptionD());
            ps.setString(6,questions.getAnswer());
            ps.setInt(7,questions.getQuestionId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
}
