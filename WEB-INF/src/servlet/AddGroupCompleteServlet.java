package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GroupBean;
import dao.DbConnectDao;
import dao.GroupDao;

@WebServlet("/AddGroupComplete")

public class AddGroupCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request , HttpServletResponse response)
		    throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		GroupDao dao = new GroupDao();


		//パラメータからグループ情報取得
		String groupName = request.getParameter("groupName");
		String description = request.getParameter("description");

		GroupBean newGroup = new GroupBean();
		newGroup.setGroupName(groupName);
		newGroup.setDescription(description);

		boolean isNewGroup = false;

		try {
			dao.getConnection();
			isNewGroup = dao.addNewGroup(newGroup);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				dao.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		if(isNewGroup){
			//RequestDispatcherオブジェクトを取得
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/group/AddGroupComplete.jsp");
			//forwardメソッドで、処理をreceive.jspに転送
			rd.forward(request, response);
		}else{
			//セッションの取得
			HttpSession session = request.getSession(false);
			String errorMessage = "このグループ名は既に利用されています。再度ご記入ください。";
			session.setAttribute("errorMessage", errorMessage);

			//RequestDispatcherオブジェクトを取得
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/group/AddGroup.jsp");
			//forwardメソッドで、処理をreceive.jspに転送
			rd.forward(request, response);
		}



		}

}

