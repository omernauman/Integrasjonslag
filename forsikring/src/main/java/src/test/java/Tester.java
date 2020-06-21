package src.test.java;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.omer.jaxrs.forsikring.model.Contract;

public class Tester {
	private static final List<String> INSURANCE_TYPES = new ArrayList<>(
			Arrays.asList("Bilforsikring", "Boligforsikring", "Helseforsikring"
			)
			);
	public static void main(String[] args) {

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		Contract contract = new Contract();
		contract.setCustomerName("Omer Nauman");
		contract.setPersonalNr("123");
		contract.setProductName(INSURANCE_TYPES.get(1));
		
		Response response = service.path("webapi")
				.path("contract")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(contract, MediaType.APPLICATION_JSON), Response.class);

		Contract contractCreated = response.readEntity(Contract.class);
		System.out.println(contractCreated);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/forsikring").build();
	}
}