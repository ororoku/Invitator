package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import bean.GroupBean;

public class GroupDao extends DbConnectDao{
		public boolean addNewGroup(GroupBean newGroup) throws SQLException{
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;

			try {
				String sql1="select group_name from grouptable where group_name = ?";
				pstmt1 = con.prepareStatement(sql1);
				pstmt1.setString(1,newGroup.getGroupName());
				rs = pstmt1.executeQuery();

				if(rs.next()){
					System.out.println("グループ名が重複しています");
					return false;
				}

				String sql2="insert into grouptable (group_name, description) values (?,?)";
				pstmt2 = con.prepareStatement(sql2);

				pstmt2.setString(1,newGroup.getGroupName());
				pstmt2.setString(2,newGroup.getDescription());
				pstmt2.executeUpdate();
				return true;

			}finally{
				if (this.rs != null) {
					this.rs.close();
				}
				if (this.pstmt != null) {
					this.pstmt.close();
				}
			}
		}
}
