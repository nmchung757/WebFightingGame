package controller;

import model.ListDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = dao.searchForListById(tempId);
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId =  Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = dao.searchForListById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				ListItemHelper daoForItems = new ListItemHelper();
				
				request.setAttribute("allItems", daoForItems.showAllItems());
				
				if (daoForItems.showAllItems().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
