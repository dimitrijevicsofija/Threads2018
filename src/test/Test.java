/*
 * Created on May 9, 2018
 *
 */
package test;

import java.awt.TextArea;
import java.util.Scanner;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer davidBowie;
	private Singer annieLennox;
	private Singer both;

	private void initializeSingingInThreads(TextArea textArea, boolean startBowie, boolean startAnnie,
			boolean startBoth) {
		String lyrics1 = "It's the terror of knowing\nWhat the world is about\nWatching some good friends, screaming\n";
		String lyrics2 = "Let me out!\n";
		String lyrics3 = "Pray tomorrow gets me higher\n" + "...\n";

		boolean stopIt = false;
		Synchronizer synch;
		
		if(startBowie== true && startAnnie== false && startBoth==false) synch = new Synchronizer(true, false, false, textArea, true, false, false);
		else if(startBoth== true && startAnnie==false && startBowie==false) synch = new Synchronizer(false, true, false, textArea, false, true, false);
		else if(startAnnie== true && startBowie==false && startBoth==false) synch = new Synchronizer(false, false, true, textArea, false, false, true);
		else synch = new Synchronizer(true, false, false, textArea, false, false, false);

		Performance firstVoicePerformance = new Performance(lyrics1, 4500);
		Performance secondVoicePerformance = new Performance(lyrics2, 3500);
		Performance thirdVoicePerformance = new Performance(lyrics3, 1500);

		davidBowie = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		both = new Singer("Bowie and Annie", Voice.BOTH, secondVoicePerformance, stopIt, synch);
		annieLennox = new Singer("Bruce Springsteen", Voice.SECOND, thirdVoicePerformance, stopIt, synch);
	}

	public void testSingInThreads(TextArea textArea, boolean startBowie, boolean startAnnie, boolean startBoth) {

		initializeSingingInThreads(textArea, startBowie, startAnnie, startBoth);

		if (startBowie)
			davidBowie.start();
		if (startBoth)
			both.start();
		if (startAnnie)
			annieLennox.start();

	}

	public synchronized void stopThreads(boolean stopBowie, boolean stopAnnie, boolean stopBoth) {
		if (stopBowie)
			davidBowie.setStopIt(true);
		if (stopBoth)
			both.setStopIt(true);
		if (stopAnnie)
			annieLennox.setStopIt(true);
	}

}
