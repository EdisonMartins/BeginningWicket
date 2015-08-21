package org.apache.wicket.app.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Welcome extends WebPage {

	static final long serialVersionUID = 1L;
	
	
	private String userID;
	
	

	public Welcome() {
		add(new Label("message", new PropertyModel<>(this, "userID")));
		
		
		Link<String> linkToUserProfile = new Link<String>("linkToUserProfile"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(UserProfilePage.class);
				
			}
			
		};
		
		
		Link<String> linkToLogin = new Link<String>("linkToLogin"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(Login.class);
				
			}
			
		};
		
		
		add(linkToUserProfile);
		add(linkToLogin);
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//bookmarkable
	public Welcome(PageParameters params){
		this();
		System.out.println("Welcome(PageParameters params)");
		this.setUserID(params.get("userID").toString());
	
	}
	
	
	
	//Getters and Setters
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	

}
