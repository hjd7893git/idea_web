package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hjd.page.PageModel;
public class servlet_page extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pageNo 	=request.getParameter("pageNo");
	String pageSize =request.getParameter("pageSize");
	com.util.Fen.setPageNo(pageNo);
	com.util.Fen.setPageSize(pageSize);
	request.getRequestDispatcher("index0.jsp").forward(request, response);
	}

}
