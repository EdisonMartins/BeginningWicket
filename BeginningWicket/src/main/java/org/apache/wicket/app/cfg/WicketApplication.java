package org.apache.wicket.app.cfg;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.app.ui.Login;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {
	
	public WicketApplication() {
		
		//Development or Deplyment  configuration
		System.out.println("-- WICKET APPLICATION: DEVELOPMENT MODE CONFIGURATION --");
		setConfigurationType(RuntimeConfigurationType.DEVELOPMENT);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		System.out.println("getHomePage()");
		//return HomePage.class;
		return Login.class;
	}
	
	@Override
	protected void init() {
		System.out.println("Iniciando aplicação com o framework Wicket!!!");
		super.init();
	}

}
