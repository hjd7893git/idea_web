package cn.hjd.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.hjd.page.PageModel;
import com.opensymphony.xwork2.ActionContext;

import cn.hjd.service.EmployeeService;

@Controller // employeeAction �����bean����spring��������
public class EmployeeAction {
    @Resource EmployeeService employeeService;
    
	public String execute(){
		//ActionContext.getContext().put("employees", employeeService.list());//���Ѳ��ҵ������ݶ��󱣴���һ��������
		PageModel model=null;
		if(com.util.Id.id==1){
			model =(employeeService.list(1,8));
		}else{				
			String pageNo=com.util.Fen.getPageNo();
			String pageSize=com.util.Fen.getPageSize();
			model =(employeeService.list(Integer.parseInt(pageNo),Integer.parseInt(pageSize)));
		}
		ActionContext.getContext().put("MODEL",model);
		ServletActionContext.getRequest().getSession().setAttribute("ADD", model);//��� ��session�У��Թ����ӷ���ʹ��
		
		ActionContext.getContext().put("employees",model.getList() );
		return "list";
	}
	
}
