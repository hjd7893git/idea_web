package cn.hjd.bean;
public class Employee {
	private String username;
	private String password;
	private Gender gender = Gender.MAN;
	private int age;
	private String yw;
	private String sx;
	private String yy;
	private String lz;
	private String wz;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getYw() {
		return yw;
	}

	public void setYw(String yw) {
		this.yw = yw;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

	public String getYy() {
		return yy;
	}

	public void setYy(String yy) {
		this.yy = yy;
	}

	public String getLz() {
		return lz;
	}

	public void setLz(String lz) {
		this.lz = lz;
	}

	public String getWz() {
		return wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}
/////////////////////////¹¹Ôìº¯Êý////////////////////////////
	public Employee(){}
	
	
	public Employee(String username, String password,  int age,
			String yw, String sx, String yy, String lz, String wz) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.yw = yw;
		this.sx = sx;
		this.yy = yy;
		this.lz = lz;
		this.wz = wz;
	}

	/////////////////////////////////////////////	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
