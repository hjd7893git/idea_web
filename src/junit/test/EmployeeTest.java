package junit.test;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hjd.bean.Employee;
import cn.hjd.bean.Gender;
import cn.hjd.service.EmployeeService;

public class EmployeeTest {
	private static EmployeeService employeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			employeeService = (EmployeeService)act.getBean("employeeServiceBean");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void save(){
		for (int i = 0; i < 100; i++) {
			employeeService.save(new Employee("liming"+i, "123456", 1,"12","12","12","12","12"));
		}
		
	}
	/**
	 * ���µ���
	 */
	@Test
	public void update(){
		Employee employee = employeeService.find("һ��һ��");
		if(employee!=null){
			employee.setGender(Gender.WOMEN);
			employee.setUsername("һ�Ĵ���");
			employeeService.update(employee);
		}else{
			System.out.println("����ʧ�ܣ�");
		}
		
	}
	/**
	 * ɾ������
	 */
	@Test
	public void delete(){
		try {
			employeeService.delete("����");
		} catch (Exception e) {
		System.out.println("ɾ��ʧ�ܣ�");
		}
	}
	/**
	 * ��������
	 */
	@Test
	public void list(){
		List<Employee> ems = (List<Employee>) (employeeService.list(1, 8).getList());
		for(Employee em: ems)
			System.out.println(em.getUsername()+"��"+em.getPassword());
	}
	/**
	 * ���ҵ���
	 */
	@Test
	public void find(){
		Employee em = employeeService.find("sdf");
		if(em!=null)
		System.out.println(em.getUsername()+"��"+em.getPassword());
		else{
			System.out.println("����ʧ�ܣ�");
		}
	}
	@Test
	public void findll(){
		List<Employee> employees =employeeService.find1();
		for (Employee employee : employees) {
			System.out.println(employee.getAge());
		}
	}
}
