package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class TestListStudentExecuteAction extends Action {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String entYearStr="";//入力された入学年度
		String classNum ="";//入力されたクラス番号
		String subject = "";//入力された科目
		String stubdentNum = "";
		int entYear = 0;// 入学年度

		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		subject = req.getParameter("f3");
		stubdentNum = req.getParameter("f4");
	}
	}
