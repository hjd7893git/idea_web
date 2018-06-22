package cn.hjd.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hjd.bean.Employee;
import cn.hjd.bean.Gender;
import cn.hjd.service.EmployeeService;
@Controller("Add")
@Scope("prototype")
public class Add {
	@Resource EmployeeService employeeService;
	private String name;
	private String pass;
	private Gender sex;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public void execute(){
		System.out.println("---进入增加方法----"+name);
		System.out.println("---进入增加方法----"+pass);
		System.out.println("---进入增加方法----"+sex);
		Employee employee =new Employee();
		employee.setGender(sex);
		employee.setUsername(name);
		employee.setPassword(pass);
		employee.setAge(age);
		employee.setYw(yw);
		employee.setSx(sx);
		employee.setYy(yy);
		employee.setLz(lz);
		employee.setWz(wz);
		employeeService.save(employee);//增加方法
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().write("true");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
