import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class HTMLWriter {
    private String outputFilename = "filesInfo.html";
    private LinkedList<Artist> artistList;

    /**
     * Default constructor
     */
    public HTMLWriter() {
        artistList = new LinkedList<>();
    }

    /**
     * Constructor with one parameter
     *
     * @param outputFilename name of the generated output html file
     */
    public HTMLWriter(String outputFilename) {
        this.outputFilename = outputFilename;
        artistList = new LinkedList<>();
    }

    /**
     * @return false when html file didn't create due to error
     * and true, when file was generate
     * @throws IOException
     */
    public boolean createHTML() throws IOException {
        File htmlFile = new File(outputFilename);
        // Check for file creation
        if (!htmlFile.createNewFile()) {
            System.out.println("An error occurred while creating html file.");
            return false;
        }
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("\n <html>").append("\n  <head>");
        htmlBuilder.append("\n   <meta charset=utf-8\">");
        htmlBuilder.append("\n  </head>");
        htmlBuilder.append("\n  <body>");
        for (Artist element : artistList) {
            htmlBuilder.append("<pre>").append(element.getName()).append("</pre>");
            /*htmlBuilder.append("<pre>").append(" ").append(element.getAlbums());*/
            /*htmlBuilder.append(element.getMinutesDuration()).append(" : ").append(element.getSecondsDuration());
            htmlBuilder.append("(").append(element.getFileLocation()).append(")").append("</pre>");*/
            for (Artist artist: artistList) {
                htmlBuilder.append("<pre>").append(artist.getName()).append("</pre>");
                for (String album: artist.getAlbumsNames()) {
                    htmlBuilder.append("<pre>").append(" " + album).append("</pre>");
                    LinkedList<Song> songs = artist.getSongsFromAlbum(album);
                    for (Song song: songs) {
                        htmlBuilder.append("<pre>").append(song.getTitle());
                        htmlBuilder.append(song.getMinutesDuration()).append(":").append(song.getSecondsDuration());
                        htmlBuilder.append("(").append(song.getFileLocation()).append(")");
                    }
                }
            }
        }


        htmlBuilder.append("\n  </body>");
        htmlBuilder.append("\n </html>");
        return true;
    }

    public void add(Artist info) {
        artistList.add(info);
    }
}
