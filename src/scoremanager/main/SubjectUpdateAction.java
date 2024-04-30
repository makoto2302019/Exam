package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//ローカル変数
		String url = "";
		//リクエストパラメーターの取得
		String subcode = req.getParameter("code");
		String subname = req.getParameter("name");
		boolean isAttend = req.getParameter("is_attend") != null;
		
		List<String> errors = new ArrayList<>();
		
		
		if (subcode != null) { //科目コードが入力されていた場合
			Subject p=new Subject();
			p.setCd(subcode);
			p.setName(subname);
			
			SubjectDao dao = new SubjectDao();
			
			//データベースに保存
			dao.save(p);
			
			//フォワード
			url = "subject_update_done.jsp";
			req.getRequestDispatcher(url).forward(req, res);
			}
		
		else {
			//科目名が未入力の場合
			errors.add("このフィールドを入力してください");
			req.setAttribute("errors", errors);
			
			//フォワード
			url = "Login.action";
			req.getRequestDispatcher(url).forward(req, res);
		}
		
		
	}

}
