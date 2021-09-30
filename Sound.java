/*
* Project: ics3u
* Package: FinalProject
* Class: Sound   
* Programmer: www.codejava.net, Aditya Pandya
* Date Created: 11/06/2020
* Description:  Begins the sound
*/	
package FinalProject;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
 
public class Sound{
     
    boolean playCompleted;
    Clip audioClip;
     
  public void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
 
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);//gets audiofile from the system.
 
            AudioFormat format = audioStream.getFormat();//set the format of the audio file to the audiofile variable
 
            DataLine.Info info = new DataLine.Info(Clip.class, format);//the info from the file is set to the info variable
 
            audioClip = (Clip) AudioSystem.getLine(info);//the audioclip is set 
           
            audioClip.open(audioStream);//opens the sound
             
            audioClip.start();//starts the sound
                         
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
    }
   
    public void stop()
    {
    audioClip.close();//if stop is called then end the music
    }
   
    public void loop()
    {
    audioClip.loop(audioClip.LOOP_CONTINUOUSLY);//if loop is called then play continuously
    }
    public void start()
    {
    	
    }
 
}