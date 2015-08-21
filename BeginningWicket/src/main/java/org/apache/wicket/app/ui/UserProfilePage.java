package org.apache.wicket.app.ui;

import java.util.Arrays;

import org.apache.wicket.app.ui.template.AppBasePage;
import org.apache.wicket.domain.model.dto.UserProfile;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class UserProfilePage extends AppBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserProfilePage() {
		//Constrói a tela por meio de componentes
		
		//Entidade ou DTO
		UserProfile userProfile = new UserProfile();
		
		//Permite compartilhar o modelo entre classes PAI e FILHAs
		CompoundPropertyModel<UserProfile> userProfileModel = new CompoundPropertyModel<>(userProfile);
		
		//Componente PAI
		Form<UserProfile> form = new UserProfileForm("userProfile", userProfileModel);
		

		TextField<String> userNameComp = new TextField<String>("name");
		TextField<String> addressComp = new TextField<String>("address");
		TextField<String> cityComp = new TextField<String>("city");

		//Select HTML
		DropDownChoice<String> coutriesComp = new DropDownChoice<>("country",
				Arrays.asList(new String[] { "India", "US", "UK" }));
		
		
		TextField<String> pinComp = new TextField<String>("pin");
		
		form.add(userNameComp);
		form.add(addressComp);
		form.add(cityComp);
		form.add(coutriesComp);
		form.add(pinComp);
		

		add(form);

	}

	//Classe anônima para controlar os eventos.
	class UserProfileForm extends Form<UserProfile>{

		private static final long serialVersionUID = 1L;

		// PropertyModel is an IModel implementation
		public UserProfileForm(String id, IModel<UserProfile> model) {
			super(id, model);
		}

		@Override
		public void onSubmit() {
			/* Print the contents of its own model object */
			System.out.println(getModelObject());

		}

	}
	
	
	
	
	
	
	
	
	
	

}
