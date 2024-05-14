package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		TestDao tesDao = new TestDao();
		SubjectDao suDao = new SubjectDao();
		ClassNumDao cNumDao = new ClassNumDao();
		
		
		//ログインユーザーの学校コードをもとに、ユーザーが所属している学校の科目一覧用データを取得
		List<Subject> list = suDao.filter(teacher.getSchool());
		
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list1 = cNumDao.filter(teacher.getSchool());
		
		List<Test> tests = null;
		
		
		StudentDao sDao = new StudentDao();
		Map<String, String> errors = new HashMap<>();
		
		
		String entYearStr ="";//入力された入学年度
		String classNum ="";//入力されたクラス番号
		String subName = "";//入力された科目名
		String Countstr ="";//入力された回数
		int entYear = 0;//入学年度
		int Count = 0;
		
		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		subName = req.getParameter("f3");
		Countstr = req.getParameter("f4");
		
		if (entYearStr !=null) {
			//数値に変換
			entYear = Integer.parseInt(entYearStr);
			}
		
		if (Countstr !=null) {
			//数値に変換
			Count = Integer.parseInt(Countstr);
			
			
		}
		
		Subject subject = new Subject();
		subject.setName(subName);
		
		if(entYear == 0 || classNum == null || subName == null || Count == 0 ){
			errors.put("f1", "入学年度とクラスと科目と回数を選択してください");
			req.setAttribute("errors", errors);
		} else {
			
			tests  = tesDao.filter(entYear,classNum,subject,Count,teacher.getSchool());
		}
		
		
		//リクエストにデータをセット
		//req.setAttribute("ent_year_set", );
		//req.setAttribute("ent_year_set", entYear);
		req.setAttribute("subject_set", list);
		req.setAttribute("class_num_set", list1);
		req.setAttribute("test_set", tests);
		//JSPへフォワード
		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}

}