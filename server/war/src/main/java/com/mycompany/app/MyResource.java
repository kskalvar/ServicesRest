/*
 * Root Resource Class
 * 
 * GET		Is used to read from a REST resource.
 * PUT 		Is used for updating a REST resource.
 * POST 	Generally used for new resource creation.
 * DELETE 	To delete a REST resource.
 */

package com.mycompany.app;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@Path("/myresource")
public class MyResource {

	private CustomerService customerService = null;

	public MyResource() {
		customerService = new CustomerService();
	}

	@POST
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject createCustomer(JAXBElement<Customer> customerElement) throws JSONException {
		Customer customer = customerElement.getValue();

		JSONObject object = new JSONObject();

		if (customerService.checkCustomerExist(customerElement.getValue().getId())) {

			object.put("stat", "Error");
			object.put("error", "Duplicate");
			
		} else {

			customerService.createCustomer(customer);
			object.put("stat", "Ok");
		}
		return object;
	}

	@PUT
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject updateCustomer(JAXBElement<Customer> customerElement) throws JSONException {

		JSONObject object = new JSONObject();
		Customer customer = customerElement.getValue();

		if (customerService.checkCustomerExist(customer.getId())) {

			customerService.updateCustomer(customer.getId(), customer);
			object.put("stat", "Ok");
		} else {

			object.put("stat", "Error");
			object.put("error", "Does Not Exist");
		}
		return object;
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getCustomer(@QueryParam("id") String id) throws JSONException {

		JSONObject object = new JSONObject();

		if (customerService.checkCustomerExist(id)) {

			object.put("id", customerService.getCustomer(id).getId());
			object.put("name", customerService.getCustomer(id).getName());
			object.put("country", customerService.getCustomer(id).getCountry());
			
		} else {
			object.put("stat", "Error");
			object.put("error", "Does Not Exist");
		}
		return object;
	}
	
	
	@GET
	@Path("/json/getid")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUniqueId() throws JSONException {

		JSONObject object = new JSONObject();
		
		object.put("id", customerService.returnUniqueId());
		
		return object;
	}
	

	@DELETE
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject deleteCustomer(@QueryParam("id") String id) throws JSONException {

		JSONObject object = new JSONObject();

		if (customerService.checkCustomerExist(id)) {

			customerService.deleteCustomer(id);
			object.put("stat", "Ok");
		} else {
			
			object.put("stat", "Error");
			object.put("error", "Does Not Exist");
		}	
		return object;
	}

}
