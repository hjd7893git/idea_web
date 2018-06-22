package cn.hjd.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.hjd.page.PageModel;
import com.opensymphony.xwork2.ActionContext;

import cn.hjd.service.EmployeeService;

@Controller // employeeAction 将这个bean交给spring容器管理
public class EmployeeAction {
    @Resource EmployeeService employeeService;
    
	public String execute(){
		//ActionContext.getContext().put("employees", employeeService.list());//将已查找到的数据对象保存在一个属性中
		PageModel model=null;
		if(com.util.Id.id==1){
			model =(employeeService.list(1,8));
		}else{				
			String pageNo=com.util.Fen.getPageNo();
			String pageSize=com.util.Fen.getPageSize();
			model =(employeeService.list(Integer.parseInt(pageNo),Integer.parseInt(pageSize)));
		}
		ActionContext.getContext().put("MODEL",model);
		ServletActionContext.getRequest().getSession().setAttribute("ADD", model);//存放 在session中，以供增加方法使用
		
		ActionContext.getContext().put("employees",model.getList() );
		return "list";
	}
	
}
