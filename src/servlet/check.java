package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjd.page.PageModel;

import cn.hjd.bean.Employee;
import cn.hjd.service.EmployeeService;

/**
 * Servlet implementation class check
 */
public class check extends HttpServlet {
	private static EmployeeService employeeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid=new String(request.getParameter("userid").getBytes("ISO-8859-1"),"gb2312");
//		System.out.println("要显示修改的页面传递过来的参数："+userid);
		//查找所有的名字，来根据传入的参数进行匹配检验
		String qq="false";
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		employeeService = (EmployeeService)act.getBean("employeeServiceBean");
		int length =((PageModel)request.getSession().getAttribute("ADD")).getTotalRecords();//取出最大记录
		System.out.println(length);
		List<Employee> ems = (List<Employee>) (employeeService.list(1,length)).getList();//进行查询
		for(Employee em: ems){
			if(em.getUsername().equals(userid)){
				qq="true";
				break;
				}
			}
		response.getWriter().write(qq);
		}
			
	}


