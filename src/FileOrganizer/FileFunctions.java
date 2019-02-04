package FileOrganizer;

import java.io.File;
import java.util.*;

public class FileFunctions {





    public String[] readSFile(String path){
        File f = new File(path);

        String[] d = f.list();


        return d;
    }

    public Set<String> getExtentions(String[] names, String[] paths){
        Set<String> types = new HashSet<>();


        for (int i = 0; i <names.length ; i++) {
            if(!new File(paths[i]).isDirectory()){
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
