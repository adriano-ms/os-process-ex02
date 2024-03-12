package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static final String OPTIONS[] = { "List Process", "Kill process by PID", "Kill process by name" };

	public static void main(String[] args) {

		KillController killController = new KillController();
		Object option = null;
		do {
			try {
				option = JOptionPane.showInputDialog(null, "Operation:", "Process Manager", JOptionPane.DEFAULT_OPTION, null,
						OPTIONS, OPTIONS[0]);
				if (option != null)
					if (option.toString() == OPTIONS[0]) {
						killController.processList();
					} else if (option.toString() == OPTIONS[1]) {
						String pid = JOptionPane.showInputDialog(null,"Type the process PID:",option.toString(),JOptionPane.DEFAULT_OPTION);
						if(pid != null) {
							String output = killController.killPid(Integer.parseInt(pid));
							JOptionPane.showMessageDialog(null, output == null ? "Process not found" : output, option.toString(), JOptionPane.INFORMATION_MESSAGE);
						}
								
					} else if (option.toString() == OPTIONS[2]) {
						String name = JOptionPane.showInputDialog(null,"Type the process name:", option.toString(),JOptionPane.DEFAULT_OPTION);
						if(name != null) {
							String output = killController.killName(name);
							JOptionPane.showMessageDialog(null, output == null ? "Process not found" : output, option.toString(), JOptionPane.INFORMATION_MESSAGE);
						}
					}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), option.toString(), JOptionPane.ERROR_MESSAGE);
				option = "";
			}
		} while (option != null);

	}

}
