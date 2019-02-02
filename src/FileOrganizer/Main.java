package FileOrganizer;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {


    File file;
    FileFunctions op;
    String[] fAmount;
    String[] files;
    String[] paths;


    public Main(){



       String s = "C:\\Users\\fahad ansar\\Desktop\\Test";

       op = new FileFunctions();

       files =  op.readFile(s,files);
       paths = new String[files.length];
        for (int i = 0; i <files.length ; i++) {
            String ft = files[i];
            paths[i] = s+File.separator;
            paths[i] = paths[i] + ft;
        }


        op.getExtentions(files);

        op.types.toArray(fAmount = new String[op.types.size()]);

        op.makeFolder(fAmount, s + File.separator);

        op.move(paths, fAmount, s + File.separator);

    }

    private void readFilePaths(String s) {

    }

    public static void main(String[] args) {
	  Main m =  new Main();
    }
}
