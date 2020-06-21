package org.omer.jaxrs.forsikring.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.omer.jaxrs.forsikring.database.DatabaseClass;
import org.omer.jaxrs.forsikring.model.Contract;

public class ContractService {
	private Map<String, Contract> contracts = DatabaseClass.getContracts();
	
	public ContractService() {	
	}

	public List<Contract> getAllContracts() {
		return new ArrayList<Contract>(contracts.values());
	}

	public Contract getContract(String contractNr) {
		return contracts.get(contractNr);
	}
	
	//Used for test only
	public Contract addContract(Contract contract) {
		contract.setContractNr(contracts.size() + 1 + contract.getCustomerName());
		contract.setDateSigned(new Date());
		contract.setStatus("Ready");		
		contracts.put(contract.getContractNr(), contract);
		return contract;
	}

}
