package FileOrganizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileFunctions {



    public File[] readSFile(String path){
        File f = new File(path);

        File[] d = f.listFiles();


        return d;
    }

    public ArrayList<String> makeIt(String[] names, String[] paths, String mainPath){

        ExtManager ext = new ExtManager();
        ArrayList<String> revertTool = new ArrayList<>();

        for (int i = 0; i< names.length ; i++) {
          if(new File(paths[i]).isFile() & getExt(names[i]).equals("") & !new File(paths[i]).isHidden()){

              File f = new File(paths[i]);
              new File(mainPath + File.separator + "Files").mkdirs();
              System.out.println(mainPath + File.separator + "Files" + File.separator + f.getName());
              f.renameTo(new File(mainPath + File.separator + "Files" + File.separator + f.getName()));

              if(!revertTool.contains(mainPath + File.separator + "Files")) {
                  revertTool.add(mainPath + File.separator + "Files");
              }

          }else if(!new File(paths[i]).isHidden()){
              //Normals_1
              if (Arrays.asList(ext.getPictures1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Pictures").mkdirs();
                  System.out.println(mainPath + File.separator + "Pictures" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Pictures" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Pictures")) {
                      revertTool.add(mainPath + File.separator + "Pictures");
                  }

              } else if (Arrays.asList(ext.getVideo1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Videos").mkdirs();
                  System.out.println(mainPath + File.separator + "Videos" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Videos" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator +"Videos")) {
                      revertTool.add(mainPath + File.separator + "Videos");
                  }

              } else if (Arrays.asList(ext.getAudio1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Audios").mkdirs();
                  System.out.println(mainPath + File.separator + "Audios" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Audios" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Audios")) {
                      revertTool.add(mainPath + File.separator + "Audios");
                  }

              } else if (Arrays.asList(ext.getDocuments1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Documents").mkdirs();
                  System.out.println(mainPath + File.separator + "Documents" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Documents" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Documents")) {
                      revertTool.add(mainPath + File.separator + "Documents");
                  }

              } else if (Arrays.asList(ext.getCompressed1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Compressed").mkdirs();
                  System.out.println(mainPath + File.separator + "Compressed" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Compressed" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Compressed")) {
                      revertTool.add(mainPath + File.separator + "Compressed");
                  }

              } else if (Arrays.asList(ext.getProgramming1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Programming").mkdirs();
                  System.out.println(mainPath + File.separator + "Programming" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Programming" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Programming")) {
                      revertTool.add(mainPath + File.separator + "Programming");
                  }
              }

              //Normals_2
              else if (Arrays.asList(ext.getPictures2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Pictures").mkdirs();
                  System.out.println(mainPath + File.separator + "Pictures" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Pictures" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Pictures")) {
                      revertTool.add(mainPath + File.separator + "Pictures");
                  }

              } else if (Arrays.asList(ext.getVideo2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Videos").mkdirs();
                  System.out.println(mainPath + File.separator + "Videos" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Videos" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Videos")) {
                      revertTool.add(mainPath + File.separator + "Videos");
                  }

              } else if (Arrays.asList(ext.getAudio2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Audios").mkdirs();
                  System.out.println(mainPath + File.separator + "Audios" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Audios" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Audios")) {
                      revertTool.add(mainPath + File.separator + "Audios");
                  }

              } else if (Arrays.asList(ext.getDocuments2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Documents").mkdirs();
                  System.out.println(mainPath + File.separator + "Documents" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Documents" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Documents")) {
                      revertTool.add(mainPath + File.separator + "Documents");
                  }

              } else if (Arrays.asList(ext.getCompressed2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Compressed").mkdirs();
                  System.out.println(mainPath + File.separator + "Compressed" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Compressed" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Compressed")) {
                      revertTool.add(mainPath + File.separator + "Compressed");
                  }

              } else if (Arrays.asList(ext.getProgramming2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Programming").mkdirs();
                  System.out.println(mainPath + File.separator + "Programming" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Programming" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Programming")) {
                      revertTool.add(mainPath + File.separator + "Programming");
                  }
              }


              //Specials_1
              else if (Arrays.asList(ext.getApplications1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Application Files").mkdirs();
                  System.out.println(mainPath + File.separator + "Application Files" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Application Files" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Application Files")) {
                      revertTool.add(mainPath + File.separator + "Application Files");
                  }

              } else if (Arrays.asList(ext.getSystemfiles1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "System Files").mkdirs();
                  System.out.println(mainPath + File.separator + "System Files" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "System Files" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "System Files")) {
                      revertTool.add(mainPath + File.separator + "System Files");
                  }

              } else if (Arrays.asList(ext.getInternet1()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Internet").mkdirs();
                  System.out.println(mainPath + File.separator + "Internet" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Internet" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Internet")) {
                      revertTool.add(mainPath + File.separator + "Internet");
                  }

              }

              //Specials_2
              else if (Arrays.asList(ext.getApplications2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Application Files").mkdirs();
                  System.out.println(mainPath + File.separator + "Application Files" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Application Files" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Application Files")) {
                      revertTool.add(mainPath + File.separator + "Application Files");
                  }

              } else if (Arrays.asList(ext.getSystemfiles2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "System Files").mkdirs();
                  System.out.println(mainPath + File.separator + "System Files" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "System Files" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "System Files")) {
                      revertTool.add(mainPath + File.separator + "System Files");
                  }

              } else if (Arrays.asList(ext.getInternet2()).contains(getExt(names[i]))) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Internet").mkdirs();
                  System.out.println(mainPath + File.separator + "Internet" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Internet" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Internet")) {
                      revertTool.add(mainPath + File.separator + "Internet");
                  }

              } else if (getExt(names[i]).equals("lnk")) {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Shortcuts").mkdirs();
                  System.out.println(mainPath + File.separator + "Shortcuts" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Shortcuts" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Shortcuts")) {
                      revertTool.add(mainPath + File.separator + "Shortcuts");
                  }

              } else {
                  File f = new File(paths[i]);
                  new File(mainPath + File.separator + "Others").mkdirs();
                  System.out.println(mainPath + File.separator + "Others" + File.separator + f.getName());
                  f.renameTo(new File(mainPath + File.separator + "Others" + File.separator + f.getName()));

                  if(!revertTool.contains(mainPath + File.separator + "Others")) {
                      revertTool.add(mainPath + File.separator + "Others");
                  }
              }
          }
        }
      return revertTool;
    }

    private String getExt(String name){
        String str = "";
        if(name.contains(".")) {
            for (int i = name.length() - 1; i >= 0; i--) {
                if (name.charAt(i) == '.') {
                    break;
                }
                str = str + name.charAt(i);
            }
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



    public  ArrayList<String> move(String[] mPath, String[] filename, String main){

        ArrayList<String> revertTool = new ArrayList<>();

        for (int i = 0; i < mPath.length; i++) {
            for (int j = 0; j < filename.length; j++) {
                File f = new File(mPath[i]);
                if(!f.isHidden()){
                    if (mPath[i].contains(filename[j]) && mPath[i].contains(".")) {
                        String ex = getExt(f.getName());
                        new File(main + File.separator + ex).mkdirs();
                        f.renameTo(new File(main + File.separator + ex + File.separator + f.getName()));

                        if (!revertTool.contains(main + File.separator + ex)) {
                            revertTool.add(main + File.separator + ex);
                        }
                    } else if (!(f.isDirectory()) && (f.isFile()) && (getExt(f.getName()).equals(""))) {
                        new File(main + File.separator + "file").mkdirs();
                        f.renameTo(new File(main + File.separator + "file" + File.separator + f.getName()));

                        if (!revertTool.contains(main + File.separator + "file")) {
                            revertTool.add(main + File.separator + "file");
                        }
                    }
                }
            }
        }
        return revertTool;
    }

}
