package cn.qianshu.mybatis.entity;

public class Librarian {

    private int id;
    private String userName;
    private String password;
    private int    age;
    private String  position;
    
    
	public Librarian(int id, String userName, String password, int age, String position) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.position = position;
	}
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", position=" + position + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
