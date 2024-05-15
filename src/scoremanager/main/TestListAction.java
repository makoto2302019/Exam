package scoremanager.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Subject;
import tool.Action;

public class TestListAction extends Action {
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        setTestListSubject(req, res);
        setTestListStudent(req, res);
        req.getRequestDispatcher("test_list.jsp").forward(req, res);
    }
    // 科目リストをセットする
    public void setTestListSubject(HttpServletRequest req, HttpServletResponse res) {
        List<Subject> subjects = fetchSubjects();
        req.setAttribute("subjects", subjects);
    }
    // 学生リストをセットする
    public void setTestListStudent(HttpServletRequest req, HttpServletResponse res) {


        List<Student> students = fetchStudents();
        req.setAttribute("students", students);
    }


    private List<Subject> fetchSubjects() {
        return new ArrayList<>();

    }

    private List<Student> fetchStudents() {
        return new ArrayList<>();

    }

}