package gui;

import java.awt.EventQueue;
import java.awt.TextArea;

import test.Test;

public class GUIKontroler {

	private Test test = new Test();

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUIKontroler kontroler = new GUIKontroler();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicGUI frame = new MusicGUI(kontroler);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
