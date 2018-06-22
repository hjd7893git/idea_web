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
	 * 更新单个
	 */
	@Test
	public void update(){
		Employee employee = employeeService.find("一心一意");
		if(employee!=null){
			employee.setGender(Gender.WOMEN);
			employee.setUsername("一心大意");
			employeeService.update(employee);
		}else{
			System.out.println("更新失败！");
		}
		
	}
	/**
	 * 删除单个
	 */
	@Test
	public void delete(){
		try {
			employeeService.delete("张昭");
		} catch (Exception e) {
		System.out.println("删除失败！");
		}
	}
	/**
	 * 查找所有
	 */
	@Test
	public void list(){
		List<Employee> ems = (List<Employee>) (employeeService.list(1, 8).getList());
		for(Employee em: ems)
			System.out.println(em.getUsername()+"、"+em.getPassword());
	}
	/**
	 * 查找单个
	 */
	@Test
	public void find(){
		Employee em = employeeService.find("sdf");
		if(em!=null)
		System.out.println(em.getUsername()+"、"+em.getPassword());
		else{
			System.out.println("查找失败！");
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
