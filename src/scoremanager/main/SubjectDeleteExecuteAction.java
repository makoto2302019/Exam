package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // リクエストから削除する科目のコードを取得
        String subCd = req.getParameter("cd");
//        String subName = req.getParameter("name");

        Subject p= new Subject();
        p.setCd(subCd);
//        p.setName(subName);

        // 科目Daoをインスタンス化
        SubjectDao sDao = new SubjectDao();

        // 科目Daoを使用して科目を削除
        boolean success = sDao.delete(p);

        req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
    }
}
