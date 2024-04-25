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

public class SubjectCreateAction extends Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		SubjectDao suDao = new SubjectDao();//科目Daoを初期化
		LocalDate todaysDate = LocalDate.now();//LocalDateインスタンスを取得
		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
		int year = todaysDate.getYear();//現在の年を取得
		
		//ログインユーザーの学校コードをもとに科目の一覧を取得
		List<Subject> list = suDao.filter(teacher.getSchool());
		
		//リクエストにデータをセット
		req.setAttribute("sc_set", list);
		req.setAttribute("name_set", list);
		
		//JSPへフォワード
		req.getRequestDispatcher("subject_create.jsp").forward(req, res);
		
		
	}
	
}
