package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnectDao {


		protected DataSource ds = null; //DataSourceの参照変数
		protected Connection con = null; //Connectionオブジェクトの参照変数
		protected PreparedStatement pstmt = null;
		protected ResultSet rs = null;
		protected Context context = null;
		protected String localName = "java:comp/env/jdbc/mecinomy";

		public void getConnection() throws NamingException,SQLException{
			//コンテキストの生成
			context = new InitialContext();
			//コンテキストを検索
			ds = (DataSource)context.lookup(localName);
			// データベースへ接続
			con = ds.getConnection();
			return;
		}


		public void closeConnection()throws SQLException{
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.pstmt != null) {
				this.pstmt.close();
			}
			if (this.con != null) {
				this.con.close();
			}
			return;
		}
}
