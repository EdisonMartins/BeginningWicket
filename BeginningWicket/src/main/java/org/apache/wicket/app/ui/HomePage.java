package org.apache.wicket.app.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomePage() {
		System.out.println("Add Label()");
		add(new Label("helloMessage", "Hello WicketWorld!"));
	}
}
