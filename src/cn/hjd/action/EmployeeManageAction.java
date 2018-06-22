package cn.hjd.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.hjd.bean.Employee;
import cn.hjd.service.EmployeeService;

@Controller 
@Scope("prototype")
public class EmployeeManageAction{
	@Resource EmployeeService employeeService;
	private Employee employee;	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addUI(){
		return "add";
	}
	public void delete() throws IOException{
		try {
			String username=com.util.Id.getUsername();
			employeeService.delete(username);
			HttpServletResponse response = ServletActionContext.getResponse() ;
			response.getWriter().write("true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String find(){
		try {
			String username=com.util.Id.getUsername();
			//获取request对象存储
			 Employee e=employeeService.find(username);
			 if(e!=null){
				 ActionContext.getContext().put("key", e);
				 return "find";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nofind";
	}
	
}
