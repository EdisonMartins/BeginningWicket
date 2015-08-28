package org.apache.wicket.app.ui;

import java.util.Arrays;

import org.apache.wicket.app.ui.template.AppBasePage;
import org.apache.wicket.domain.model.dto.UserProfile;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.validator.RangeValidator;

public class UserProfilePage extends AppBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserProfilePage() {
		// Constrói a tela por meio de componentes

		// Entidade ou DTO
		UserProfile userProfile = new UserProfile();

		// Permite compartilhar o modelo entre classes PAI e FILHAs
		CompoundPropertyModel<UserProfile> userProfileModel = new CompoundPropertyModel<>(userProfile);

		// Componente PAI
		Form<UserProfile> form = new UserProfileForm("userProfile", userProfileModel);

		TextField<String> userNameComp = new TextField<String>("name");
		userNameComp.setRequired(true);
		
		TextField<String> addressComp = new TextField<String>("address");
		TextField<String> cityComp = new TextField<String>("city");

		// Select HTML
		DropDownChoice<String> coutriesComp = new DropDownChoice<>("country",
				Arrays.asList(new String[] { "India", "US", "UK" }));

		TextField<String> pinComp = new TextField<String>("pin");
		pinComp.setRequired(true);
		pinComp.add(RangeValidator.range(1000, 5000));
		pinComp.setType(int.class);

		form.add(userNameComp);
		form.add(addressComp);
		form.add(cityComp);
		form.add(coutriesComp);
		form.add(pinComp);

		add(new FeedbackPanel("feedback"));
		add(form);

	}

	// Classe anônima para controlar os eventos.
	class UserProfileForm extends Form<UserProfile> {

		private static final long serialVersionUID = 1L;

		// PropertyModel is an IModel implementation
		public UserProfileForm(String id, IModel<UserProfile> model) {
			super(id, model);

		}

		@Override
		public void onSubmit() {

			/* Print the contents of its own model object */
			System.out.println(getModelObject());

			UserProfile up = (UserProfile) getModelObject();
			int pin = up.getPin();
			String name = up.getName();

			if (name == null) {
				error("User Name is a required field");
			}

			

			int minPinVal = 0;
			int maxPinVal = 5000;

			if (pin < minPinVal || pin > maxPinVal) {
				error("Please enter pin in the range " + Integer.toString(minPinVal) + " - "
						+ Integer.toString(maxPinVal));
			}
			
			info(getDefaultModelObjectAsString());
			

		}

	}

}
