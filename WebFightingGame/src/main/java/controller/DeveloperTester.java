package controller;

import java.util.List;

import model.Developer;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class DeveloperTester {
	public static void main(String[] args) {
		Developer netherRealmStudios = new Developer("NetherRealm Studios");
		Developer nintendo = new Developer("Nintendo");
	
		DeveloperHelper dh = new DeveloperHelper();
	
		dh.insertDeveloper(netherRealmStudios);
		dh.insertDeveloper(nintendo);
		
		List<Developer> allDevelopers = dh.showAllDevelopers();
		for (Developer a: allDevelopers) {
			System.out.println(a.toString());
		}
	}
}
