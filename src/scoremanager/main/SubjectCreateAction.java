package scoremanager.main;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class SubjectCreateAction extends Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		String SubjectCode="";//入力された科目コード
		String SubjectName="";//入力された科目名
		
		List<Subject> subject = null;//科目リスト
		LocalDate todaysDate = LocalDate.now();//LcalDateインスタンスを取得
		int year = todaysDate.getYear();//現在の年を取得
		SubjectDao suDao = new SubjectDao();
		Map<>
	}
	

}
