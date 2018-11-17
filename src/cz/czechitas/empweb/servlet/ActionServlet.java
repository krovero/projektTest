package cz.czechitas.empweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.empweb.controller.ActiveController;
import cz.czechitas.empweb.controller.DeactiveController;
import cz.czechitas.empweb.controller.InsertController;
import cz.czechitas.empweb.controller.ViewController;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/Action")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private ActiveController activeController = new ActiveController ();
private DeactiveController deactiveController = new DeactiveController ();
private InsertController insertcontroller = new InsertController ();
private ViewController viewController = new ViewController();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		 if (action == null) { 
			 viewController.handle(request, response);
		 }else if (action.equals("active")) {
			activeController.handle(request, response);
		}else if (action.equals("deactive")){	
			deactiveController.handle(request, response);
		}else if (action.equals ("insert")){
			insertcontroller.handle(request, response);
		}else {viewController.handle(request, response);}
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletConfig().getServletContext().getRequestDispatcher("/Sumary.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
