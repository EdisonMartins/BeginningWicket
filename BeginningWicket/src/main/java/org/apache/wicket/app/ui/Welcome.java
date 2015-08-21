package org.apache.wicket.app.ui;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class Welcome extends WebPage {

	static final long serialVersionUID = 1L;

	private String userID;
	@SuppressWarnings("unused")
	private Page prevPage;

	
	
	
	public Welcome(String userID, Page prevPage) {
		add(new Label("message", new PropertyModel<>(this, "userID")));
		
		System.out.println("UserID: " + userID);
		System.out.println("prevPage: " + prevPage.getId());
		
		this.userID = userID;
		this.prevPage = prevPage;

		Link<String> linkToLogin = new Link<String>("linkToLogin") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				//Retorna o link para uma mesma instancia.
				setResponsePage(prevPage == null ? new Login() : prevPage);

			}
		};
		
		
		Link<String> linkToUserProfile = new Link<String>("linkToUserProfile") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(UserProfilePage.class);

			}

		};
		
		
		add(linkToUserProfile);
		add(linkToLogin);

	}

	// Getters and Setters
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
