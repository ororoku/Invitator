package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddGroupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request , HttpServletResponse response)
		    throws ServletException, IOException{

		//RequestDispatcherオブジェクトを取得
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/group/AddGroup.jsp");
		//forwardメソッドで、処理をreceive.jspに転送
		rd.forward(request, response);
		}

}
