package scoremanager.main;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;
 
public class SubjectUpdateExecuteAction extends Action {
 
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
					
					Subject subject = new Subject();
					String subCd = req.getParameter("cd");
					String subName = req.getParameter("name");
					
//					subject.getCd();
//					subject.getSchool();
//					subject.getName();
					
					Subject p= new Subject();
					p.setCd(subCd);
					p.setName(subName);
 
					//科目Dao
					SubjectDao sDao= new SubjectDao();
					//DBに保存
					sDao.save(subject);
					//登録完了
 
					//JSPへフォワード
					req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
 
}

}