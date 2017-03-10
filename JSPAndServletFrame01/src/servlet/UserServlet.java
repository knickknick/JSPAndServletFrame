package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemsDAO;

public class UserServlet extends HttpServlet{

	private String action ; //��ʾ�û��Ķ��� ��login,register
	//��Ʒҵ���߼���Ķ���
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
			
			if(action.equals("Register")) //�������֤ע����Ϣ
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
			
			if(action.equals("Login")) //�������֤��½��Ϣ
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
