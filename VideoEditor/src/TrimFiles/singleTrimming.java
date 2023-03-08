package TrimFiles;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import java.io.File;
import it.sauronsoftware.jave.VideoAttributes;
public class singleTrimming {
    public static void main(String[] args) {
        try{
            File source = new File("src\\sampleSource.flv");
            File target = new File("src\\target.flv");
            if(!target.exists()) target.createNewFile();
            
            VideoAttributes video = new VideoAttributes();
//            video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
            video.setCodec("flv");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
//            video.setSize(new VideoSize(400, 300));
            
            AudioAttributes audio = new AudioAttributes();
//            audio.setCodec(AudioAttributes.DIRECT_STREAM_COPY);
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
            
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("flv");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);
            attrs.setOffset(new Float(34));
//            attrs.setDuration(new Float(20));
            attrs.setDuration(new Float(40));
            
            Encoder encoder = new Encoder();
            encoder.encode(source, target, attrs);         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
/*
// create a File object for the input video file
File inputFile = new File("input.avi");

// create a File object for the output video file
File outputFile = new File("output.mp4");

// create a MultimediaObject for the input file
MultimediaObject input = new MultimediaObject(inputFile);

// create a MultimediaObject for the output file
MultimediaObject output = new MultimediaObject(outputFile);

// create an EncodingAttributes object to specify the output format
EncodingAttributes attrs = new EncodingAttributes();
attrs.setFormat("mp4");

// create a Encoder object and use it to encode the input file to the output file
Encoder encoder = new Encoder();
encoder.encode(input, output, attrs);

System.out.println("Conversion complete.");


*/