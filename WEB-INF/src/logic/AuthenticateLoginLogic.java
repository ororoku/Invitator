package logic;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.UserBean;
import dao.UserDao;

public class AuthenticateLoginLogic extends AbstractLogic{
	public UserBean authCheck(String userId,String password)throws SQLException,NamingException{
		UserDao userDao = new UserDao();
		UserBean userBean = null;
		Connection con=null;
		//ユーザー名とパスワードが空でなかったらログインチェック
		if((userId!=null&&!userId.isEmpty())&&(password!=null&&!password.isEmpty())){
			try{
				//データベースに接続して、ユーザー情報を取得
				con=userDao.getConnection();
				userBean=userDao.getUserById(con,userId,password);
				//ユーザー情報が取得でき、パスワードが一致したらログイン成功
				if(userBean!=null&&userBean.getPassword().equals(password)){
					return userBean;
				}
			}finally{
				//データベースと切断
				userDao.closeConnection(con);
			}
		}
		//ここまで来たらログインは失敗
		return null;
	}
}
