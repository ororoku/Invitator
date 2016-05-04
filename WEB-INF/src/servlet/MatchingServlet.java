package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.recruit.logic.ChangeStockLogic;

public class MatchingServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -6945929109627628817L;
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException,IOException {
		ServletContext sc=null;
		//エラーメッセージの一時保存用変数
		String message=null;
		//デフォルトの転送先
		String destination = "/WEB-INF/jsp/index.jsp";
		//エラーメッセージ処理クラスのインスタンス化
		ArrayList<String> error = new ArrayList<String>();
		//セッションの取得（なければ作成）
		HttpSession session = request.getSession(false);
		//更新のロジック
		ChangeStockLogic logic = new ChangeStockLogic();

	}
int purpose;
int timeHour;
int timeMin;

}
