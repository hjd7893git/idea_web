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
@Transactional//ʹ��ע��ķ�ʽ��������
public class EmployeeServiceBean implements EmployeeService{
	@Resource SessionFactory factory;//ʹ��ע��ķ�ʽ������ע�뵽beanservice�� ��

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
		  List<Employee> list2 = queryD.list();	//���Ҷ�����¼
		  int total=0;  						//�����ѯ���ܼ�¼���ĳ�ʼ��
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
		//factory.getCurrentSession() �õ���spring�������Ѿ��õ������session����
		factory.getCurrentSession().persist(employee);
	}

	public void update(Employee employee) {
		factory.getCurrentSession().merge(employee);
	}

	public List<Employee> find1() {
		return factory.getCurrentSession().createQuery("from Employee s").list();
	}

}
