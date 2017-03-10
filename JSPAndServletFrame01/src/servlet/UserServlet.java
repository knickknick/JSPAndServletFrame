package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemsDAO;

public class UserServlet extends HttpServlet{

	private String action ; //表示用户的动作 ：login,register
	//商品业务逻辑类的对象
	private ItemsDAO idao = new ItemsDAO();
	
	
	public UserServlet() {
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("action")!=null){
			
			this.action = request.getParameter("action");
			
			if(action.equals("Register")) //如果是验证注册信息
			{
				if(idao.testRegister(request.getParameter("username"),request.getParameter("password"),request.getParameter("email"),request.getParameter("phonenumber")))
				{
					request.getRequestDispatcher("/RegisterSuccess.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/RegisterFailure.jsp").forward(request, response);
				}
			}
			
			if(action.equals("Login")) //如果是验证登陆信息
			{
				if(idao.testLogin(request.getParameter("username"),request.getParameter("password")))
				{
					request.getRequestDispatcher("/LoginSuccess.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/LoginFailure.jsp").forward(request, response);
				}
			}
		}
	}
	
}
