import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class HTMLWriter {
    private String outputFilename;
    private LinkedList<String> filesInfo;

    public HTMLWriter(String outputFilename) {
        this.outputFilename = outputFilename;
        filesInfo = new LinkedList<String>();
    }

    public boolean createHTML() throws IOException {
        File htmlFile = new File(outputFilename);
        if (!htmlFile.createNewFile()) {
            System.out.println("An error occurred while creating html file.");
            return false;
        }
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");

        return true;
    }
}
