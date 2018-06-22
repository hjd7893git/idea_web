package cn.hjd.service;

import java.util.List;

import com.hjd.page.PageModel;

import cn.hjd.bean.Employee;

public interface EmployeeService {
	public void save(Employee employee);
	public void update(Employee employee);
	public Employee find(String username);
	public void delete(String... usernames);
	public PageModel list(int pageNo, int pageSize);
	public List<Employee> find1();
}
