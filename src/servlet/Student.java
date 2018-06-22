package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hjd.bean.Employee;
import cn.hjd.service.EmployeeService;

public class Student extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag=0;
		response.setCharacterEncoding("UTF-8");
		EmployeeService employeeService=null;
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		employeeService = (EmployeeService)act.getBean("employeeServiceBean");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String pass = request.getParameter("pass");
		List<Employee> list= employeeService.find1();
		for (Employee employee : list) {
			if(employee.getUsername().equals(name)&&employee.getPassword().equals(pass)){
				request.setAttribute("sh", employee);
				flag=1;
				break;
			}
		}
		if(flag==1)
		request.getRequestDispatcher("students.jsp").forward(request, response);
		else{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("µÇÂ½Ê§°Ü£¡");
		}
		
	}

}
