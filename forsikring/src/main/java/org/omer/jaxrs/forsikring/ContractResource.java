package org.omer.jaxrs.forsikring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codefagsystem.Fagsystem;
import org.codefagsystem.FagsystemService;
import org.omer.jaxrs.forsikring.database.DatabaseClass;
import org.omer.jaxrs.forsikring.model.Contract;
import org.omer.jaxrs.forsikring.service.ContractService;
import org.omer.jaxrs.mock.service.LetterService;

@Path("/contract")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContractResource {
	
	private Map<String, Contract> contracts = DatabaseClass.getContracts();
	
	FagsystemService fagSystemService = new FagsystemService();
	Fagsystem fagSystemPort = fagSystemService.getFagsystemPort();	
	LetterService letterService = new LetterService();
	
	//ContractService used only for test
	ContractService contractService = new ContractService();
		
	@GET
	public List<Contract> getContracts() {
		//return contractService.getAllContracts();
		return new ArrayList<Contract>(contracts.values());
	}
	
	@POST	
	public Contract addContract(Contract contract) {
		String customerNr = fagSystemPort.createCustomer(contract.getCustomerName());
		contract.setCustomerNr(customerNr);
		String contractNr = fagSystemPort.createContract(customerNr);
		contract.setContractNr(contractNr);
		contract.setDateSigned(letterService.getSignature(contractNr));
		String status = fagSystemPort.updateContractStatus(contractNr);
		contract.setStatus(status);
		contract.setAktive(false);
		if(status.equalsIgnoreCase("avtale sendt")) {
			contract.setAktive(true);
		}
		contracts.put(contractNr, contract);
		return contract;
		//return contractService.addContract(contract);
	}

}
