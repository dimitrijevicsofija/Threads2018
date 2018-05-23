/*
 * Created on May 9, 2018
 *
 */
package test;

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
    
    private void initializeSingingInThreads() {
        String lyrics1 = "It's the terror of knowing\nWhat the world is about\nWatching some good friends, screaming\n";
        String lyrics2 = "Let me out!\n";
        String lyrics3 = "Pray tomorrow gets me higher\n" +"...\n";
       
      
        
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(true, false, false);
        
        Performance firstVoicePerformance = new Performance(lyrics1, 4500);
        Performance secondVoicePerformance = new Performance(lyrics2, 3500);
        Performance thirdVoicePerformance = new Performance(lyrics3, 1500);
        
        davidBowie = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        both = new Singer("Bowie and Annie", Voice.BOTH, secondVoicePerformance, stopIt, synch);
        annieLennox = new Singer("Bruce Springsteen", Voice.SECOND, thirdVoicePerformance, stopIt, synch);
    }
    
    public void testSingInThreads() {
        
        initializeSingingInThreads();
        
        davidBowie.start();
        both.start();
        annieLennox.start();
        
        IN.nextLine();
        davidBowie.setStopIt(true);
        both.setStopIt(true);
        annieLennox.setStopIt(true);
        
    }
    
  
}

