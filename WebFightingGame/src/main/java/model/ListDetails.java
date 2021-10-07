package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Developer developer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListItem> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListDetails(int id, String listName, Developer developer, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.developer = developer;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, Developer developer, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.developer = developer;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, Developer developer) {
		super();
		this.listName = listName;
		this.developer = developer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", developer=" + developer + ", listOfItems="
				+ listOfItems + "]";
	}
}
