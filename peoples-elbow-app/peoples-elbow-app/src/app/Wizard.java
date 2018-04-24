
package app;
	import javax.swing.JOptionPane;
	import javax.swing.JLabel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	import java.util.Arrays;

	/* 
	 * This class encapsulates the Swing code used
	 * throughout these examples to get a username
	 * and password to authenticate to a database.
	 */
public class Wizard implements AutoCloseable{
		public Wizard() {
			JTextField user = new JTextField();
			JPasswordField pass = new JPasswordField();
			int result = JOptionPane.showConfirmDialog(
				null, 
				new Object[]{
					new JLabel("Username: "), user,
					new JLabel("Password: "), pass
				}, 
				"Credentials", 
				JOptionPane.OK_CANCEL_OPTION
			);

			if (result != JOptionPane.OK_OPTION)
				throw new SecurityException("User did not provide credentials.");
			
			username = user.getText();
			password = pass.getPassword();
		}
		
		private String username;
		public String getUsername() {
			return username;
		}
		
		private char[] password;
		public String getPassword() {
			return password != null ? new String(password) : null;
		}
		
		public static String getData(String prompt) {
			JTextField data = new JTextField();
			int result = JOptionPane.showConfirmDialog(
				null, 
				new Object[]{
					new JLabel(prompt + ": "), data
				}, 
				"Credentials", 
				JOptionPane.OK_CANCEL_OPTION
			);

			if (result != JOptionPane.OK_OPTION)
				return null;
		return data.getText();
		}

		@Override
		public void close() {
			if (username != null)
				username = null;
			
			if (password != null) {
				Arrays.fill(password, (char) 0);
				password = null;
			}
		}
}
