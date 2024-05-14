package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import tool.Action;

public class TestListSubjectExcuteAction extends Action {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Subject> list = suDao.filter(teacher.getSchool());

}
}