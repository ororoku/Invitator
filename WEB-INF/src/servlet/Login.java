package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1l;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException{

		Boolean isLogin = false;

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		ArrayList<String> error = new ArrayList<String>();
		ServletContext sc=null;
		String destination=null;

		HttpSession session = req.getSession(true);

		@SuppressWarnings("unchecked")
		ArrayList<String> temp = (ArrayList<String>)session.getAttribute("errormessage");
		if(temp != null){
			for(String message:temp){
				error.add(message);
			}
			session.removeAttribute("errormessage");
		}

		//ログイン処理後の転送先
		destination = "/";

		String userId="";
		String password="";

		UserBean userBean=null;

		HashMap<String, >
	}
}
