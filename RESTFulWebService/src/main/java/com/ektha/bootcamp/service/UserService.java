package com.ektha.bootcamp.service;

import java.io.File;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ektha.bootcamp.application.UserNotFoundException;
import com.ektha.bootcamp.model.User;

@Path("/user/service")
public class UserService {

	@PUT
	@Path("/create")
	public void createUser() {
		System.out.println("PUT");
	}

	@GET
	@Path("/get/{userId}")
	public void getUser(@PathParam("userId") String userId, @QueryParam("fname") String firstname,
			@HeaderParam("host") String headerParam) {
		System.out.println("GET");
		System.out.println("UserId = " + userId);
		System.out.println("First Name = " + firstname);
		System.out.println("Header Param = " + headerParam);
	}

	/**
	 * @context is used to specify that context information should be injected
	 *          into this method param. URIInfo is used for getting uri
	 *          components
	 * @param uris
	 */
	@GET
	@Path("/getURIParams/{param1}/{param2}")
	public void getURIParams(@Context UriInfo uris) {
		MultivaluedMap<String, String> mm = uris.getPathParameters();
		keyValueExtractor(mm);
	}

	@GET
	@Path("/getHeaderParams")
	public void getHeaderParams(@Context HttpHeaders headers) {
		System.out.println("Multple Header Params");
		MultivaluedMap<String, String> mm = headers.getRequestHeaders();
		keyValueExtractor(mm);
	}

	@GET
	@Path("/getHeaderParams/getCookies")
	public void getCookiesParams(@Context HttpHeaders headers) {
		System.out.println("Multple Header Params");
		MultivaluedMap<String, String> mmHeader = headers.getRequestHeaders();
		keyValueExtractor(mmHeader);
		System.out.println("Multple Cookies params:");
		Map<String, Cookie> mmCookie = headers.getCookies();
		Set<String> keySet = mmCookie.keySet();
		for (String key : keySet) {
			System.out.println("Key is : " + key + " and Cookie value is : " + mmCookie.get(key).getValue());
		}
	}

	@GET
	@Path("/getQueryParams/{param1}/{param2}")
	public void getQueryParams(@Context UriInfo uris) {
		System.out.println("Multiple Path Params");
		MultivaluedMap<String, String> mmPath = uris.getPathParameters();
		keyValueExtractor(mmPath);
		System.out.println("Multiple Query Params");
		MultivaluedMap<String, String> mmQuery = uris.getQueryParameters();
		keyValueExtractor(mmQuery);
	}

	private void keyValueExtractor(MultivaluedMap<String, String> mm) {
		Set<String> keySet = mm.keySet();

		for (String key : keySet) {
			System.out.println("Key is : " + key + " and Value is : " + mm.get(key));
		}
	}

	@POST
	@Path("/post")
	public void updateUser(@FormParam("username") String userName, @CookieParam("email") String cookieParam) {
		System.out.println("POST");
		System.out.println("Username is : " + userName);
		System.out.println("Email is : " + cookieParam);
	}

	@POST
	@Path("/postMultipleFormParams")
	public void postMultipleFormParam(MultivaluedMap<String, String> formParams) {
		System.out.println("POST Multiple Form Params");
		keyValueExtractor(formParams);
	}

	@DELETE
	public void deleteUser() {
		System.out.println("DELETE");
	}

	@Path("/special")
	public SpecialUser getSpecialUser() {
		return new SpecialUser();
	}
	
	@GET
	@Path("/getUserId/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	//By default text_html if none specified
	public String getUserId(@PathParam("userid") String userID) {
		System.out.println("Inside getUserID  where userID is " + userID);
		return userID + " modified";
	}
	
	@GET
	@Path("/getUserInfo/{userid}/{email}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	//@Produces(MediaType.APPLICATION_XML)
	//By default text_html if none specified
	public User getUserInfo(@PathParam("userid") String userID,
			@PathParam("email") String email) {
		System.out.println("Inside getUserID  where userID is " + userID);
		User user = new User();
		user.setUserId(userID);
		user.setEmail(email);
		return user;
	}
	
	@POST
	@Path("/processInput")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String processInput(String input){
		return "Processed " + input;
	}
	
	@GET
	@Path("/sendResponse")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sendResponse(){
		
		File file = new File("C:\\Users\\Boot Camp User 06\\Desktop\\unused desktop\\BLOG\\corejava\\basic\\interviewquestion.txt");
		
		return Response.ok().entity(file).header("Content-Disposition", "attachment; filename=\"interviewquestion.txt\"").build();
		
	}
	
	@POST
	@Path("/receiveUser")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response receiveUser(User user){
		System.out.println("User Id is : " + user.getUserId() + " And email is : " + user.getEmail());
		return Response.ok().build();
	}
	
	@GET
	@Path("/getUserObject")
	@Produces(MediaType.TEXT_PLAIN)
	public User getUser(){
		User user = new User();
		user.setEmail("hiqmat@jj.com");
		user.setUserId("dssadsda122");
		return user;
	}
	
	@GET
	@Path("/getUserInformation")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getUserInformation(@QueryParam("userId") String userId) throws UserNotFoundException{
		
		if(userId == null || userId.isEmpty()){
			throw new UserNotFoundException(); //custom exception
		} else {
			User user = new User();
			user.setEmail("hello@vallo.com");
			user.setUserId("asdsad123");
			return Response.ok().entity(user).build();
		}
	}
}
