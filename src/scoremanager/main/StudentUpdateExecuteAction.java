package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res
			) throws Exception {

		//ローカル変数
		String url = "";
		//リクエストパラメーターの取得 2
		Integer ent_year = Integer.parseInt(req.getParameter("ent_yaer"));
		String stuNum = req.getParameter("no");
		String stuName = req.getParameter("name");
		String classNum = req.getParameter("class_num");
		boolean isAttend = req.getParameter("si_attend") != null;

		// エラーメッセージをセット
		List<String> errors = new ArrayList<>();

//		Student p=new Student();
//		p.setNo(stuNum);
//		p.setName(stuName);
//		p.setEntYear(ent_year);
//		p.setClassNum(classNum);
//		p.setAttend(isAttend);
//
//		StudentDao dao = new StudentDao();
//
//		dao.save(p);

		if (stuName != null) {// 氏名が入力されていた場合

			Student p=new Student();
			p.setNo(stuNum);
			p.setName(stuName);
			p.setEntYear(ent_year);
			p.setClassNum(classNum);
			p.setAttend(isAttend);

			StudentDao dao = new StudentDao();

			// データベースに保存
			dao.save(p);

			//フォワード
			url = "student_update_done.jsp";
			req.getRequestDispatcher(url).forward(req, res);

			}
		else {
			// 入力年度ば未入力の場合
			errors.add("このフィールドを入力してください");
			req.setAttribute("errors", errors);

			//フォワード
			url = "Login.action";
			req.getRequestDispatcher(url).forward(req, res);
		}
	}
}
