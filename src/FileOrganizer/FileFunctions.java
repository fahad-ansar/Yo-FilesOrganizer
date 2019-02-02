package FileOrganizer;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class FileFunctions {

    Set<String> types = new HashSet<>();

    public String[] readFile(String path, String[] files){
        File f = new File(path);


        files = f.list();


        return files;
    }

    public Set<String> getExtentions(String[] names){

        for (int i = 0; i <names.length ; i++) {
            if(names[i].indexOf('.')>=0) {
                String str = "";
                for (int j = names[i].length() - 1; j > 0; j--) {
                    if (names[i].charAt(j) == '.') {
                        break;
                    }
                    str = str + names[i].charAt(j);
                }

                types.add("" + new StringBuffer(str).reverse());
            }
        }
        return types;
    }

    private String getext(String s){
        String str = null;
        if(s.indexOf('.')>=0) {
            for (int j = s.length(); j > 0; j--) {
                if (s.charAt(j) == '.') {
                    break;
                }
                str = str + s.charAt(j);
            }
            str = "" + new StringBuffer(str).reverse();
        }
        return str;
    }

    public void makeFolder(String[] fPath, String main){
        for (int i = 0; i <fPath.length ; i++) {
            File file =  new File(main +fPath[i]);
            file.mkdir();
        }

    }

    public void move(String[] mPath, String[] filename, String main){
        for (int i = 0; i < mPath.length ; i++) {
            for (int j = 0; j < filename.length ; j++) {
               if(mPath[i].contains(filename[j])) {
                   File f = new File(mPath[i]);
                   f.renameTo(new File(main + filename[j]+ File.separator + f.getName()));
               }
            }
        }
    }

}
