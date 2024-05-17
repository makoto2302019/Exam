package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action{

	@Override

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception{

		//DBから科目の詳細を取得

				HttpSession session = req.getSession();//セッション
				Teacher teacher = (Teacher)session.getAttribute("user");

				String cd = req.getParameter("cd");

				SubjectDao subjectdao = new SubjectDao();// 科目Daoを初期化

				//String schoolCd = teacher.getSchool().getCd();

				Subject subject = subjectdao.get(cd, teacher.getSchool());

				req.setAttribute("subject", subject);

		//JSPへフォワード

		req.getRequestDispatcher("subject_update.jsp").forward(req,res);

	}

}