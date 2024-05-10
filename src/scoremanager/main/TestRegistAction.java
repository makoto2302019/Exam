package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class TestRegistAction extends Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		String entYearStr ="";//入力された入学年度
		String classNum ="";//入力されたクラス番号
		String subName = "";//入力された科目名
		String Count ="";//入力された回数
		int entYeat = 0;//入学年度
		
		List<>
		
	}

}