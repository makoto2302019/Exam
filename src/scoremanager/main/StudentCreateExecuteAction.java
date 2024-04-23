package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res
			) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");

		//ローカル変数
		String url = "";
		//リクエストパラメーターの取得 2
		Integer ent_year = Integer.parseInt(req.getParameter("ent_yaer"));
		String stuNum = req.getParameter("no");
		String stuName = req.getParameter("name");
		String classNum = req.getParameter("class_num");
		boolean isAttend = true;

		// エラーメッセージをセット
		List<String> errors = new ArrayList<>();

		if (ent_year != 0) {// 入学年度が入力されていた場合

			Student p=new Student();
			p.setNo(stuNum);
			p.setName(stuName);
			p.setEntYear(ent_year);
			p.setClassNum(classNum);
			p.setAttend(isAttend);
			p.setSchool(teacher.getSchool());

			StudentDao dao = new StudentDao();
			if (dao.get(p.getNo()) == null) {
				// 学生番号が重複していない場合
				// データベースに保存
				dao.save(p);
			}
			else {
				// 学生番号が重複している場合
				errors.add("学生番号が重複しています。");
				req.setAttribute("errors_num", errors);

				//フォワード
				url = "StudentCreate.action";
				req.getRequestDispatcher(url).forward(req, res);
			}

			req.getRequestDispatcher("student_create_done.jsp").forward(req, res);

		} else {
			// 入力年度ば未入力の場合
			errors.add("入学年度を選択してください");
			req.setAttribute("errors_year", errors);

			//フォワード
			url = "StudentCreate.action";
			req.getRequestDispatcher(url).forward(req, res);
		}
	}
}
