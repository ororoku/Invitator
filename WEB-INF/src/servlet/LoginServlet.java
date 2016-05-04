package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import logic.AuthenticateLoginLogic;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1l;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{

		Boolean isLogin = false;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ArrayList<String> error = new ArrayList<String>();
		ServletContext sc=null;
		String destination=null;

		HttpSession session = request.getSession(true);

		@SuppressWarnings("unchecked")
		ArrayList<String> temp = (ArrayList<String>)session.getAttribute("errormessage");
		if(temp != null){
			for(String message:temp){
				error.add(message);
			}
			session.removeAttribute("errormessage");
		}

		//ログイン処理後の転送先
		destination = "WEB-INF/post/Post.jsp";

		String userId="";
		String password="";

		UserBean userBean=null;

		//ServletContextオブジェクトを取得
		sc = this.getServletContext();
		//顧客IDの取得
		userId=request.getParameter("username").trim();
		//パスワードの取得
		password=request.getParameter("password").trim();

		//ユーザー名とパスワードが空でなかったらログインチェック
		if((userId!=null&&!userId.isEmpty())&&(password!=null&&!password.isEmpty())){
			try{
				AuthenticateLoginLogic loginCheck = new AuthenticateLoginLogic();
				//データベースに接続して、ユーザー情報を取得
				userBean = loginCheck.authCheck(userId, password);
				//ユーザーが存在した
				if(userBean!=null){
					isLogin=true;
					//セッションを再作成する
					session.invalidate();
					session = request.getSession(true);
					//ログイン属性詰め直し
					session.setAttribute("username", userBean.getUserId());
					session.setAttribute("descript", userBean.getPassword());
					destination="WEB-INF/post/Post.jsp";
				}else{
					//ユーザー名かパスワードが間違っている場合の処理
					error.add("ログイン処理に失敗しました。ユーザー名とパスワードが間違っている可能性があります");
				}
			}catch(SQLException|NamingException e){
				error.add("(LoginServlet)ログイン処理に失敗しました。データベースに障害が発生している可能性があります"+e.getMessage());
			}
		}else{//ユーザー名とパスワードが空だった場合の処理
			error.add("(LoginServlet)ログイン処理に失敗しました。ユーザー名とパスワードは省略できません。");
		}

		if(isLogin&&error.isEmpty()){

		}else{
			//最終的になんらかの障害が発生している
			error.add("(LoginServlet)ログインに失敗しました。");
			session.setAttribute("errormessage",error);
			destination="/WEB-INF/jsp/common/LoginError.jsp";
		}

		if(!error.isEmpty()){//異常系
			request.setAttribute("errormessage", error);
			System.out.println("リダイレクト先："+request.getContextPath()+destination);
			//異常系はエラーメッセージを持たせるため、フォワード
			sc.getRequestDispatcher(destination).forward(request, response);
			return;
		}else{//正常系
			System.out.println("リダイレクト先："+request.getContextPath()+destination);
			response.sendRedirect(request.getContextPath()+destination);
			return;
		}


	}
}
