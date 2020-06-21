package org.omer.jaxrs.forsikring.database;

import java.util.HashMap;
import java.util.Map;

import org.omer.jaxrs.forsikring.model.Contract;

public class DatabaseClass {
	private static Map<String, Contract> contracts = new HashMap<>();
	
	public static Map<String, Contract> getContracts() {
		return contracts;
	}
	
	
}
