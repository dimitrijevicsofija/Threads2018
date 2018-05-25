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
	private JButton btnStartBowie;
	private JButton btnStartAnnie;
	private JButton btnStartBoth;
	private JButton btnStopBowie;
	private JButton btnStopAnnie;
	private JButton btnStopDuet;

	/**
	 * Create the frame.
	 */
	public MusicGUI(GUIKontroler kontroler) {
		this.kontroler = kontroler;
		setTitle("Under pressure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnStart());
		contentPane.add(getTextAreaLyrics());
		contentPane.add(getBtnStop());
		contentPane.add(getBtnStartBowie());
		contentPane.add(getBtnStartAnnie());
		contentPane.add(getBtnStartBoth());
		contentPane.add(getBtnStopBowie());
		contentPane.add(getBtnStopAnnie());
		contentPane.add(getBtnStopDuet());
	}

	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					kontroler.getTest().testSingInThreads(textAreaLyrics, true, true, true);

				}
			});
			btnStart.setBounds(30, 34, 124, 25);
		}
		return btnStart;
	}

	private TextArea getTextAreaLyrics() {
		if (textAreaLyrics == null) {
			textAreaLyrics = new TextArea();
			textAreaLyrics.setBounds(35, 215, 369, 158);
		}
		return textAreaLyrics;
	}

	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().stopThreads(true, true, true);
				}
			});
			btnStop.setBounds(197, 34, 124, 25);
		}
		return btnStop;
	}

	private JButton getBtnStartBowie() {
		if (btnStartBowie == null) {
			btnStartBowie = new JButton("Start Bowie");
			btnStartBowie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().testSingInThreads(textAreaLyrics, true, false, false);
				}
			});
			btnStartBowie.setBounds(30, 81, 124, 25);
		}
		return btnStartBowie;
	}

	private JButton getBtnStartAnnie() {
		if (btnStartAnnie == null) {
			btnStartAnnie = new JButton("Start Annie");
			btnStartAnnie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().testSingInThreads(textAreaLyrics, false, true, false);
				}
			});
			btnStartAnnie.setBounds(30, 119, 124, 25);
		}
		return btnStartAnnie;
	}

	private JButton getBtnStartBoth() {
		if (btnStartBoth == null) {
			btnStartBoth = new JButton("Start duet");
			btnStartBoth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					kontroler.getTest().testSingInThreads(textAreaLyrics, false, false, true);
				}
			});
			btnStartBoth.setBounds(30, 162, 124, 25);
		}
		return btnStartBoth;
	}

	private JButton getBtnStopBowie() {
		if (btnStopBowie == null) {
			btnStopBowie = new JButton("Stop Bowie");
			btnStopBowie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().stopThreads(true, false, false);
				}
			});
			btnStopBowie.setBounds(197, 81, 124, 25);
		}
		return btnStopBowie;
	}

	private JButton getBtnStopAnnie() {
		if (btnStopAnnie == null) {
			btnStopAnnie = new JButton("Stop Annie");
			btnStopAnnie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().stopThreads(false, true, true);
				}
			});
			btnStopAnnie.setBounds(197, 119, 124, 25);
		}
		return btnStopAnnie;
	}

	private JButton getBtnStopDuet() {
		if (btnStopDuet == null) {
			btnStopDuet = new JButton("Stop duet");
			btnStopDuet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.getTest().stopThreads(false, false, true);
				}
			});
			btnStopDuet.setBounds(197, 162, 124, 25);
		}
		return btnStopDuet;
	}
}
