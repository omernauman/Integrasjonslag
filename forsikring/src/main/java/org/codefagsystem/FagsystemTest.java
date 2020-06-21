package org.codefagsystem;

public class FagsystemTest {

	public static void main(String[] args) {
		FagsystemService service = new FagsystemService();
		Fagsystem fagSystemPort = service.getFagsystemPort();
		String customerNr = fagSystemPort.createCustomer("Omer Nauman");
		String contractNr = fagSystemPort.createContract(customerNr);
		String status = fagSystemPort.updateContractStatus(contractNr);
		System.out.println(customerNr + "\t" + contractNr + "\t" + status);
	}

}
