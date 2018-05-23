/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private boolean thirdVoiceFlag;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
        this.thirdVoiceFlag = thirdVoiceFlag;
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
    
    
    
    private void sing(String lyrics, int delay) {
        System.out.println(lyrics);
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

