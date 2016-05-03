package bean;

public class UserBean implements java.io.Serializable {

	private static final long serialVersionUID = 1l;
	String userId;
	String userName;
	String password;
	String userImage;
	String description;
	String address;

	public UserBean(String userId, String userName, String password, String userImage, String description, String address){
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userImage = userImage;
		this.description = description;
		this.address = address;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		if(userId!=null&&userId.equals("")){
			this.userId = userId;
		}else{
			System.err.println("(UserBean)idが空またはnullです。");
		}
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		if(userName!=null&&userName.equals("")){
			this.userName = userName;
		}else{
			System.err.println("(UserBean)userNameが空またはnullです。");
		}
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		if(password!=null&&password.equals("")){
			this.password = password;
		}else{
			System.err.println("(UserBean)passwordが空またはnullです。");
		}
	}

	public String getUserImage(){
		return userImage;
	}

	public void setUserImage(String userImage){
		if(userImage!=null&&userImage.equals("")){
			this.userImage = userImage;
		}else{
			System.err.println("(UserBean)userImageが空またはnullです。");
		}
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		if(description!=null&&description.equals("")){
			this.description = description;
		}else{
			System.err.println("(UserBean)descriptionが空またはnullです。");
		}
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		if(address!=null&&address.equals("")){
			this.address = address;
		}else{
			System.err.println("(UserBean)addressが空またはnullです。");
		}
	}

}
