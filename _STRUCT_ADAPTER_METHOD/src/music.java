//Target Interface
interface mediaplayer {
    public void play(String type, String filename);
}


//Adapter class implements client interface and keep reference of adaptee type
class MediaAdapter implements mediaplayer {
    AdvancedMEdiaPLayer adaptee = new AdvancedMEdiaPLayer();

    @Override
    public void play(String type, String filename) {
        if (type.equalsIgnoreCase("mp3")) {
            adaptee.playMP3(filename);
        } else if (type.equalsIgnoreCase("mp4")) {
            adaptee.playMP4(filename);
        } else if (type.equalsIgnoreCase("avi")) {
            adaptee.playAVI(filename);
        } else if (type.equalsIgnoreCase("vlc")) {
            adaptee.playVLC(filename);
        } else {
            System.out.println("File not Supported for the player..");
        }
    }
}


//Adaptee Class
class AdvancedMEdiaPLayer {
    public void playMP3(String name) {
        System.out.println("Playing MP3 file :" + name);
    }

    public void playMP4(String name) {
        System.out.println("Playing MP4 file :" + name);
    }

    public void playAVI(String name) {
        System.out.println("Playing AVI file :" + name);
    }

    public void playVLC(String name) {
        System.out.println("Playing VLc file :" + name);
    }

}


//Basic Funtionality used By the user
class BasicMediaPlayer implements mediaplayer {
    MediaAdapter md = new MediaAdapter();

    @Override
    public void play(String type, String filename) {

        //Adapter Method we have to write this
//        if(type.equalsIgnoreCase("vlc")){
//
//            System.out.println("Playing VLC file :"+filename +"VLC type");
//        }
//        else{
//            System.out.println("File not supported of type "+ filename);
//        }

        //BY implementing adapter Pattern
        md.play(type, filename);
    }
}


//Client
class testing {
    public static void main(String[] args) {
        mediaplayer mp = new BasicMediaPlayer();
        mp.play("vlc", "video1.vlc");
        mp.play("mp4", "music.mp4");
        mp.play("avi", "new.avi");
        mp.play("mp5", "new.avi");
    }
}