package bean;

public class GroupBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	String groupId;
	String groupName;
	String description;
	String groupImage;
	int isdelete;


	public GroupBean(){
		super();
	}


	public GroupBean(String groupId, String groupName, String description, String groupImage, int isdelete) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.description = description;
		this.groupImage = groupImage;
		this.isdelete = isdelete;
	}


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGroupImage() {
		return groupImage;
	}


	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
	}


	public int getIsdelete() {
		return isdelete;
	}


	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
}
