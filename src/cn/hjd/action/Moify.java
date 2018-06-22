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

@Controller("qq") 
@Scope("prototype")//为了多线程的安全，必须加此属性
public class Moify {
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
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public void execute() throws IOException{
		System.out.println("所要替换的name是："+id);
		System.out.println("替换成的name是："+name);
		System.out.println("要替换的性别是："+sex);
		Employee employee =employeeService.find(id);
		employee.setUsername(name);
		employee.setPassword(pass);
		employee.setGender(sex);
		employee.setAge(age);
		employee.setYw(yw);
		employee.setSx(sx);
		employee.setYy(yy);
		employee.setLz(lz);
		employee.setWz(wz);
		employeeService.update(employee);
		HttpServletResponse response =ServletActionContext.getResponse();
		response.getWriter().write("true");
	}
}
