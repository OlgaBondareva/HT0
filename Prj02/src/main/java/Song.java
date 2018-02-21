import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Song {
    private String fileLocation;
    private String title;
    private String genre;
    private String artist;
    private String album;
    private double duration;
    private int minutesDuration;
    private int secondsDuration;

    public Song(String fileLocation) {
        this.fileLocation = fileLocation;
        InputStream input;
        ContentHandler handler;
        Metadata metadata = null;
        Parser parser;
        ParseContext parseCtx;
        try {
            input = new FileInputStream(new File(fileLocation));
            handler = new DefaultHandler();
            metadata = new Metadata();
            parser = new Mp3Parser();
            parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();
        } catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }

        title = metadata.get("title");
        artist = metadata.get("xmpDM:artist");
        genre = metadata.get("xmpDM:genre");
        album = metadata.get("xmpDM:album");
        duration = Double.parseDouble(metadata.get("xmpDM:duration"));
        minutesDuration = (int) (duration / 60000);
        secondsDuration = (int) (duration % 60000) / 1000;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuration() {
        return duration;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public int getMinutesDuration() {
        return minutesDuration;
    }

    public int getSecondsDuration() {
        return secondsDuration;
    }
}
