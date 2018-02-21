import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    //static final Logger checkSumLogger = LogManager.getLogger(Main.class);
    //static final Logger userLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            System.out.println("You didn't specify directory in the command line!");
            return;
        }*/
        String arg = "D:/Music";
        String extension = "mp3";
        // List of locations from command line
        LinkedList<String> locations = new LinkedList<>();

        TreeMap<Song, String> songs = new TreeMap<>();
        LinkedList<Artist> artists = new LinkedList<>();

        HashSet<String> checkSums = new HashSet<>();
        HTMLWriter htmlWriter = new HTMLWriter();
        //Collections.addAll(locations, args);
        Collections.addAll(locations, arg);
        for (String location : locations) {
            LinkedList<Song> tmp = filesSearch(location, extension);
            if (tmp.isEmpty()) {
                System.out.println("No mp3 files found in " + location);
            }
            for (Song element : tmp) {
                songs.put(element, element.getArtist());
            }
        }

        if (songs.isEmpty()) {
            System.out.println("Songs list is empty.");
            return;
        }
        String lastArtist = null;
        for (Song s : songs.keySet()) {
            /*if (!checkSums.add(s.getCheckSum())) {
                checkSumLogger.info(s.getFileLocation());
            }*/
            if (s.getArtist().equals(lastArtist)) {
                artists.getLast().addSong(s);
            } else {
                artists.add(new Artist(s.getArtist()));
                artists.getLast().addSong(s);
                lastArtist = s.getArtist();
            }
        }
        for (Artist element : artists) {
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
     * @param root      Specify the root directory
     * @param extension Specify ext. of searching files
     * @return list of files with specified extension
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

