package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		//DBから科目の詳細を取得
			HttpSession session = req.getSession();
			Teacher teacher = (Teacher)session.getAttribute("user");

			String cd = req.getParameter("cd");

			SubjectDao subjectdao = new SubjectDao();

			Subject subject = subjectdao.get(cd, teacher.getSchool());

			req.setAttribute("subject", subject);

		//JSPへフォワード
			req.getRequestDispatcher("subject_delete.jsp").forward(req, res);
	}

}
