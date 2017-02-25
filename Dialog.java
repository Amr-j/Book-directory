import javax.swing.*;
public class Dialog {

	/** Creates a Dialog object for handling popup dialog boxes. */
	public Dialog() {
	}

	/** Displays a dialog box with help text where the user should enter an integer that'll be returned.
	  * If the user gives an incorrect value or clicks on "cancel" Integer.MAX_VALUE will be returned.
	  */
	public int readInt(String s) {
		String in = JOptionPane.showInputDialog(s);
		try {
			int i = Integer.parseInt(in);
			return i;
		} catch (NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}

	/** Displays a dialog box with help text where the user should enter a string that'll be returned .
	  * If the user clicks on cancel null value will be returned.
	  */
	public String readString(String s) {
		String in = JOptionPane.showInputDialog(s);
		if (in == null) {
			return null;
		} else {
			return in.trim();
		}
	}

	/** Shows a dialog box with string text s. */
	public void printString(String s) {
	   JOptionPane.showMessageDialog(null, s, "",JOptionPane.PLAIN_MESSAGE);
	}
}
