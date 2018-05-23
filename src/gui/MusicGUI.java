package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import music.Synchronizer;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.Button;

public class MusicGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnStart;
	private TextArea textAreaLyrics;
	private GUIKontroler kontroler;
	private JButton btnStop;

	/**
	 * Create the frame.
	 */
	public MusicGUI(GUIKontroler kontroler) {
		this.kontroler = kontroler;
		setTitle("Under pressure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnStart());
		contentPane.add(getTextAreaLyrics());
		contentPane.add(getBtnStop());
	}

	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				kontroler.callSingingInThread(textAreaLyrics);

				}
			});
			btnStart.setBounds(30, 34, 97, 25);
		}
		return btnStart;
	}
	private TextArea getTextAreaLyrics() {
		if (textAreaLyrics == null) {
			textAreaLyrics = new TextArea();
			textAreaLyrics.setBounds(30, 85, 369, 158);
		}
		return textAreaLyrics;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().stopThreads();
				}
			});
			btnStop.setBounds(197, 34, 97, 25);
		}
		return btnStop;
	}
}
