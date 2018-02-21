import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            System.out.println("You didn't specify directory in the command line!");
            return;
        }*/
        String arg = "D:/Music";
        String extension = ".mp3";
        LinkedList<String> locations = new LinkedList<>();
        TreeMap<Song, String> songs = new TreeMap<>();
        LinkedList<Artist> artists = new LinkedList<>();
        HTMLWriter htmlWriter = new HTMLWriter();
        //Collections.addAll(locations, args);
        Collections.addAll(locations, arg);
        try {
            for (String location : locations) {
                LinkedList<Song> tmp = (filesSearch(location, extension));
                for (Song element : tmp) {
                    songs.put(element, element.getArtist());
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("No mp3 fle found in directory.");
            System.out.println(ex.getMessage());
        }

        String lastArtist = null;
        for (Song s : songs.keySet()) {
            if (s.getArtist().equals(lastArtist)) {
                artists.getLast().addSong(s);
            } else {
                artists.add(new Artist(s.getArtist()));
                artists.getLast().addSong(s);
                lastArtist = s.getArtist();
            }
        }
        for (Artist element: artists) {
            htmlWriter.addArtist(element);
        }
        if (htmlWriter.createHTML()) {
            System.out.println("HTML created.");
        } else {
            System.out.println("HTML didn't created.");
        }
    }


    /**
     * Method returns LinkedList of files with specified extension from specified directories
     *
     * @param root
     * @param extension
     * @return
     */
    public static LinkedList filesSearch(String root, String extension) {
        File rootDir = new File(root);
        LinkedList result = new LinkedList();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else if (currentFile.getName().contains(extension)) {
                result.add(new Song(currentFile.getAbsolutePath()));
            }
        }
        return result;
    }
}

