package org.apache.wicket.app.ui;

import org.apache.wicket.app.ui.template.AppBasePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

public class Login extends AppBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userID;
	private String password;

	public Login() {
		// Constroi a tela
		
		//FeedBack Messages
		FeedbackPanel feedback = new FeedbackPanel("feedback");
		
		

		TextField<String> userIdField = new TextField<>("userID", new PropertyModel<>(this, "userID"));
		PasswordTextField passField = new PasswordTextField("password", new PropertyModel<>(this, "password"));

		// Indica se o campo será reiniciado quando for processado.
		passField.setResetPassword(false);

		Form<String> form = new LoginForm("loginForm");
		form.add(userIdField);
		form.add(passField);
		
		add(feedback);
		add(form);

	}

	// Classe anônima
	class LoginForm extends Form<String> {
		private static final long serialVersionUID = 1L;

		public LoginForm(String id) {
			super(id);
		}

		
		//Implementação do listener
		@Override
		protected void onSubmit() {
			System.out.println("onSubmit()");
			String userId = getUserID();
			String password = getPassword();
			System.out.println("Usuário: " + userId);
			System.out.println("Senha: " + password);

			if (authenticate(userId, password)) {

				// Exibe WelcomePage como resposta
				Welcome welcomePage = new Welcome(userId, Login.this);
				setResponsePage(welcomePage);
			} else {
				System.out.println("Usuário ou Senha está incorreta!");
				String errMsg = getLocalizer().getString("login.errors.invalidCredentials ", Login.this, "Unable to sign you in");
				
				//Registrando o erro
				error(errMsg);
				
				
			}

		}

	}

	public final boolean authenticate(final String username, final String password) {
		if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password))
			return true;
		else
			return false;
	}

	// Getters and Setters

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
