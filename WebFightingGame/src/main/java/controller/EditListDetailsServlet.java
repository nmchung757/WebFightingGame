package controller;

import model.ListItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Developer;
import model.ListDetails;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ListItemHelper lih = new ListItemHelper();
		DeveloperHelper dh = new DeveloperHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String developerName = request.getParameter("developerName");
		Developer newDeveloper = dh.findDeveloper(developerName);
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
			listToUpdate.setListOfItems(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setDeveloper(newDeveloper);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
