package scoremanager.main;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
		SubjectDao suDao = new SubjectDao();// 
		 LocalDate todaysDate = LocalDate.now();// LcalDateインスタンスを取得	
		 int year = todaysDate.getYear();
		
		//ログインユーザーの学校コードをもとに、ユーザーが所属している学校の科目一覧用データを取得
		List<bean.Subject> list = suDao.filter(teacher.getSchool());
		
		
		// リクエストにデータをセット
		req.setAttribute("subject_set", list);
		//JSPへフォワード
		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
		
		
	}

}