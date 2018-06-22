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
//		System.out.println("Ҫ��ʾ�޸ĵ�ҳ�洫�ݹ����Ĳ�����"+userid);
		//�������е����֣������ݴ���Ĳ�������ƥ�����
		String qq="false";
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		employeeService = (EmployeeService)act.getBean("employeeServiceBean");
		int length =((PageModel)request.getSession().getAttribute("ADD")).getTotalRecords();//ȡ������¼
		System.out.println(length);
		List<Employee> ems = (List<Employee>) (employeeService.list(1,length)).getList();//���в�ѯ
		for(Employee em: ems){
			if(em.getUsername().equals(userid)){
				qq="true";
				break;
				}
			}
		response.getWriter().write(qq);
		}
			
	}


