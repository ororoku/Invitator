package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Index")


public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request , HttpServletResponse response)
		    throws ServletException, IOException{

		//RequestDispatcherオブジェクトを取得
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login/Login.jsp");
		//forwardメソッドで、処理をreceive.jspに転送
		rd.forward(request, response);
		}

}
