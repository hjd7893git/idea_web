package cn.hjd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hjd.page.PageModel;

import cn.hjd.bean.Employee;
import cn.hjd.service.EmployeeService;

@Service 
@Transactional//使用注解的方式配置事务
public class EmployeeServiceBean implements EmployeeService{
	@Resource SessionFactory factory;//使用注解的方式将属性注入到beanservice中 ，

	public void delete(String... usernames) {
		for(String username : usernames){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Employee.class, username));
		}
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Employee find(String username) {
		return (Employee)factory.getCurrentSession().get(Employee.class, username);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public PageModel list(int pageNo,int pageSize) {
		PageModel pageModel=null;
        Employee admin=null;  		
		Session session =factory.getCurrentSession();	
		String hql="from Employee s";
		
		Query query =session.createQuery(hql);			
		
		query.setFirstResult((pageNo-1)*pageSize);	
 		query.setMaxResults(pageSize);				
		List<Employee> list1 =query.list();
		//////////////
		  Query queryD =session.createQuery(hql);
		  List<Employee> list2 = queryD.list();	//查找多条记录
		  int total=0;  						//定义查询的总记录数的初始化
          for(Employee a:list2){  
          	total++;
          }  
          pageModel =new PageModel();
          pageModel.setList(list1);
          pageModel.setPageNo(pageNo);
          pageModel.setPageSize(pageSize);
          pageModel.setTotalRecords(total);
		return pageModel;
	}
    
	public void save(Employee employee) {
		//factory.getCurrentSession() 得到由spring创建的已经得到事务的session对象
		factory.getCurrentSession().persist(employee);
	}

	public void update(Employee employee) {
		factory.getCurrentSession().merge(employee);
	}

	public List<Employee> find1() {
		return factory.getCurrentSession().createQuery("from Employee s").list();
	}

}
