package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action{
	public void execute(
		HttpServletRequest req, HttpServletResponse res
	) throws Exception {

		HttpSession session=req.getSession();

		if (session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");

//			req.getRequestDispatcher("logout.jsp").forward(req, res);
		}
		req.getRequestDispatcher("logout.jsp").forward(req, res);
	}
}
