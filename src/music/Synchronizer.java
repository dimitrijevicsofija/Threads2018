/*
 * Created on May 10, 2018
 *
 */
package music;

import java.awt.TextArea;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private boolean thirdVoiceFlag;
    private TextArea textArea;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVoiceFlag, TextArea textArea) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
        this.thirdVoiceFlag = thirdVoiceFlag;
        this.textArea = textArea;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (!firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (!secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singThirdVoice(String lyrics, int delay) {
        while (!thirdVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    
    
    public void sing(String lyrics, int delay) {
        textArea.append(lyrics +"\n");
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       if(firstVoiceFlag) {
        	firstVoiceFlag = false;
        	secondVoiceFlag = true;
        	thirdVoiceFlag = false;
        	notifyAll();
        	return;
        }
        
       if(secondVoiceFlag) {
       	firstVoiceFlag = false;
       	secondVoiceFlag = false;
       	thirdVoiceFlag = true;
       	notifyAll();
       	return;
       }
       
       if(thirdVoiceFlag) {
       	firstVoiceFlag = true;
       	secondVoiceFlag = false;
       	thirdVoiceFlag = false;
       	notifyAll();
       	return;
       }
         
    }
    
}

