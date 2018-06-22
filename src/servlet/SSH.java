package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSH extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(Integer.parseInt(request.getParameter("flag"))==0){
			try {
				Thread.sleep(500);
				//com.util.Id.id=1;
				request.getRequestDispatcher("employee/list.action").forward(request, response);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(Integer.parseInt(request.getParameter("flag"))==1){
			String username= request.getParameter("id");
			com.util.Id.setUsername(username);
			request.getRequestDispatcher("employee/manage_delete.action").forward(request, response);
		
		}else if(Integer.parseInt(request.getParameter("flag"))==2){
			String username= request.getParameter("findid");
			com.util.Id.setUsername(username);
			System.out.println("从jsp页面传入的参数是："+com.util.Id.getUsername());
			request.getRequestDispatcher("employee/manage_find.action").forward(request, response);
		}
	}

}
