package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.GroupBean;
import dao.GroupDao;

@WebServlet("/AddGroupComplete")

public class AddGroupCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArrayList<String> formlists = new ArrayList<String>();

		//写真アップロード関連
				//保存先のパスを指定
				String path = getServletContext().getRealPath("images");
				File f = new File(path);
				//フォルダなかったら作る
				if(!f.exists()){
					f.mkdirs();
				}

				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				sfu.setFileSizeMax(Long.parseLong("4294967296"));

				try {
					List<FileItem> list = sfu.parseRequest(request);
					for(FileItem item:list){
						 if (!item.isFormField()){
						String filename = item.getName();
						filename = (new File(filename)).getName();
									item.write(new File(path + "/" + filename));
						request.setAttribute("filename", filename);
						 } else{
							 String element = item.getString();
							 element= new String(element.getBytes("8859_1"), "UTF-8");
							 formlists.add(element);
						 }
					}
				}catch (FileUploadException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}


		GroupDao dao = new GroupDao();

		//パラメータからグループ情報取得
//		String groupName = request.getParameter("groupName");
//		String description = request.getParameter("description");
		String groupName = formlists.get(0);
		String description = formlists.get(1);


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

