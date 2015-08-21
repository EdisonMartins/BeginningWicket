package org.apache.wicket.app.ui.template;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.app.ui.panel.FooterPanel;
import org.apache.wicket.app.ui.panel.HeaderPanel;
import org.apache.wicket.app.ui.panel.MenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class JugTemplate extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CONTENT_ID = "contentComponent";
	private Component headerPanel;
	private Component menuPanel;
	private Component footerPanel;

	public JugTemplate() {
		System.out.println("JugTemplate");
		add(headerPanel = new HeaderPanel("headerPanel").add(new AttributeModifier("style", "color:red;")));
		add(menuPanel = new MenuPanel("menuPanel"));
		add(footerPanel = new FooterPanel("footerPanel"));
		add(new Label(CONTENT_ID, "Put your content here"));
	}

	
	//Getters
	public Component getHeaderPanel() {
		return headerPanel;
	}

	public Component getMenuPanel() {
		return menuPanel;
	}

	public Component getFooterPanel() {
		return footerPanel;
	}
	
	
	
	

}
