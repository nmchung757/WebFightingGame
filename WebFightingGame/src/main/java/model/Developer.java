package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
@Entity
@Table(name="developer")
public class Developer {
	@Id
	@GeneratedValue
	private int id;
	private String developerName;
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Developer(int id, String developerName) {
		super();
		this.id = id;
		this.developerName = developerName;
	}
	public Developer(String developerName) {
		super();
		this.developerName = developerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	
	@Override
	public String toString() {
		return "Developer [id=" + id + ", developerName=" + developerName + "]";
	}
}
