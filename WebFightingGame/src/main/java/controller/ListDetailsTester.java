package controller;

import java.util.ArrayList;
import java.util.List;

import model.Developer;
import model.ListDetails;
import model.ListItem;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class ListDetailsTester {
	public static void main(String[] args) {
		Developer bandaiNamcoEntertainment = new Developer("Bandai Namco Entertainment");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListItem tekken7 = new ListItem("Tekken 7", "2015");
		ListItem soulcaliburVI = new ListItem("Soulcalibur VI", "2018");
		
		List<ListItem> bandaisItems = new ArrayList<ListItem>();
		bandaisItems.add(tekken7);
		bandaisItems.add(soulcaliburVI);
		
		ListDetails bandaisList = new ListDetails("Bandai's List", bandaiNamcoEntertainment);
		bandaisList.setListOfItems(bandaisItems);
		
		ldh.insertNewListDetails(bandaisList);
		
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
}
