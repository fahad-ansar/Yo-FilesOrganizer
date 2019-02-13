package FileOrganizer;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileFunctions {



    public File[] readSFile(String path){
        File f = new File(path);

        File[] d = f.listFiles();


        return d;
    }

    public void makeIt(String[] names, String[] paths, String mainPath){

        ExtManager ext = new ExtManager();

        for (int i = 0; i< names.length ; i++) {

            //Normals_1
            if(Arrays.asList(ext.getPictures1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Pictures").mkdirs();
                System.out.println(mainPath + File.separator + "Pictures" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Pictures" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getVideo1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Videos").mkdirs();
                System.out.println(mainPath + File.separator + "Videos" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Videos" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getAudio1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Audios").mkdirs();
                System.out.println(mainPath + File.separator + "Audios" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Audios" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getDocuments1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Documents").mkdirs();
                System.out.println(mainPath + File.separator + "Documents" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Documents" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getCompressed1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Compressed").mkdirs();
                System.out.println(mainPath + File.separator + "Compressed" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Compressed" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getProgramming1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Programming").mkdirs();
                System.out.println(mainPath + File.separator + "Programming" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Programming" + File.separator + f.getName()));

            }

            //Normals_2
            else if(Arrays.asList(ext.getPictures2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Pictures").mkdirs();
                System.out.println(mainPath + File.separator + "Pictures" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Pictures" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getVideo2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+ "Videos").mkdirs();
                System.out.println(mainPath + File.separator + "Videos" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Videos" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getAudio2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+ "Audios").mkdirs();
                System.out.println(mainPath + File.separator + "Audios" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Audios" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getDocuments2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Documents").mkdirs();
                System.out.println(mainPath + File.separator + "Documents" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Documents" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getCompressed2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Compressed").mkdirs();
                System.out.println(mainPath + File.separator + "Compressed" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Compressed" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getProgramming2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Programming").mkdirs();
                System.out.println(mainPath + File.separator + "Programming" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Programming" + File.separator + f.getName()));

            }


            //Specials_1
            else if(Arrays.asList(ext.getApplications1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Application Files").mkdirs();
                System.out.println(mainPath + File.separator + "Application Files" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Application Files" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getSystemfiles1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"System Files").mkdirs();
                System.out.println(mainPath + File.separator + "System Files" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "System Files" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getInternet1()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Internet").mkdirs();
                System.out.println(mainPath + File.separator + "Internet" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Internet" + File.separator + f.getName()));

            }

            //Specials_2
            else if(Arrays.asList(ext.getApplications2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Application Files").mkdirs();
                System.out.println(mainPath + File.separator + "Application Files" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Application Files" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getSystemfiles2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"System Files").mkdirs();
                System.out.println(mainPath + File.separator + "System Files" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "System Files" + File.separator + f.getName()));

            }else if(Arrays.asList(ext.getInternet2()).contains(getExt(names[i]))){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Internet").mkdirs();
                System.out.println(mainPath + File.separator + "Internet" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Internet" + File.separator + f.getName()));

            }

            else if(getExt(names[i]).equals("lnk")){
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Shortcuts").mkdirs();
                System.out.println(mainPath + File.separator + "Shortcuts" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Shortcuts" + File.separator + f.getName()));
            }

            else{
                File f = new File(paths[i]);
                new File(mainPath+File.separator+"Others").mkdirs();
                System.out.println(mainPath + File.separator + "Others" + File.separator + f.getName());
                f.renameTo(new File(mainPath + File.separator + "Others" + File.separator + f.getName()));
            }
        }

    }

    private String getExt(String name){
        String str = "";
        for (int i = name.length() -1; i >= 0; i--) {
            if (name.charAt(i) == '.') {
                break;
            }
            str = str + name.charAt(i);
        }

        return new StringBuffer(str).reverse().toString();
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



    public void move(String[] mPath, String[] filename, String main){
        for (int i = 0; i < mPath.length ; i++) {
            for (int j = 0; j < filename.length ; j++) {
               if(mPath[i].contains(filename[j])) {
                   File f = new File(mPath[i]);
                   new File(main+File.separator+ getExt(filename[j])).mkdirs();
                   System.out.println(main+File.separator+ getExt(filename[j]));
                   f.renameTo(new File(main + getExt(filename[j])+ File.separator + f.getName()));
               }
            }
        }
    }

}
