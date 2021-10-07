package controller;

import model.Developer;
import model.ListDetails;
import model.ListItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper lih = new ListItemHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String developerName = request.getParameter("developerName");
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
		
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		Developer developer = new Developer(developerName);
		ListDetails gld = new ListDetails(listName, developer);
		
		gld.setListOfItems(selectedItemsInList);
		ListDetailsHelper glh = new ListDetailsHelper();
		glh.insertNewListDetails(gld);
		
		System.out.println("Success!");
		System.out.println(gld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
