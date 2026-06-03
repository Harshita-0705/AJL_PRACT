 // Existing Class
class OldSpeaker {

    public void playMusic() {
        System.out.println("Playing Music...");
    }
}

// Target Interface
interface MediaPlayer {
    void play();
}

// Adapter Class
class SpeakerAdapter implements MediaPlayer {

    OldSpeaker speaker;

    public SpeakerAdapter(OldSpeaker speaker) {
        this.speaker = speaker;
    }

    public void play() {
        speaker.playMusic();
    }
}

// Main Class
public class AdapterDemo {

    public static void main(String[] args) {

        OldSpeaker speaker = new OldSpeaker();

        MediaPlayer player = new SpeakerAdapter(speaker);

        player.play();
    }
}