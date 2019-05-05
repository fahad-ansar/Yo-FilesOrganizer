package FileOrganizer;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {


    File file;


    ArrayList<ArrayList<String>> fdata = new ArrayList<>();


    public Main(){


        JFileChooser fd =  new JFileChooser();

        fd.setCurrentDirectory(new File(System.getProperty("user.home")));
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int d = fd.showOpenDialog(new JFrame());

        if (d == JFileChooser.APPROVE_OPTION) {
            File select = fd.getSelectedFile();
            String s =  select.getAbsolutePath();

            int n = JOptionPane.showConfirmDialog(new JFrame(),"Do you want to Organize subdirectories also?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());

            if(n ==2){
                System.exit(0);
            }

            String[] choices = {"Organize by format (.doc , .jpg , etc)", "Organize by Type (Documents, Pictures , etc)"};
            String number = (String) JOptionPane.showInputDialog(null, "Organization Type","Yo!", JOptionPane.QUESTION_MESSAGE, new ImageIcon(),choices, choices[1]); // Initial choice
            System.out.println(number);


            //current directory
            if(n == 1){
                FileFunctions op = new FileFunctions();
                ArrayList<ArrayList<String>> revertTool = doCurrent(s , op, number);


                int undo = JOptionPane.showConfirmDialog(new JFrame(),"Do you like the file organization we did?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());

                if(undo==1){
                    int revert = JOptionPane.showConfirmDialog(new JFrame(),"Do you want to undo it?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());


                        for (int i = 0; i <revertTool.size() ; i++) {
                            for (int j = 0; j <revertTool.get(i).size() ; j++) {
                                File revertFile =  new File(revertTool.get(i).get(j));
                                if(revertFile.exists()) {
                                    if (Objects.requireNonNull(revertFile.listFiles()).length != 0) {
                                        File[] revertContent = revertFile.listFiles();

                                        for (int k = 0; k < revertContent.length; k++) {
                                            File contentFile = revertContent[k];
                                            contentFile.renameTo(new File(s + File.separator + revertContent[k].getName()));
                                            System.out.println(s + File.separator + revertContent[k].getName());
                                        }
                                    }

                                    revertFile.delete();
                                }
                            }
                        }


                }

            //Subdirectories
            }else if(n == 0){

                ArrayList<ArrayList<String>> data =  new ArrayList<>();
                ArrayList<ArrayList<String>> revertTool;

                doSub(s,data);

                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                        doSub(String.valueOf(fdata.get(i).get(j)), data);
                    }
                }


                FileFunctions op = new FileFunctions();
                revertTool = doCurrent(s , op, number);

                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                         revertTool.addAll(doCurrent(fdata.get(i).get(j), new FileFunctions(), number));
                    }
                }

                int undo = JOptionPane.showConfirmDialog(new JFrame(),"Do you like the file organization we did?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());

                if(undo==1){
                    int revert = JOptionPane.showConfirmDialog(new JFrame(),"Do you want to undo it?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());

                    if(revert==0){

                        ArrayList<String> rList = new ArrayList<>();

                        for (int i = 0; i <fdata.size() ; i++) {
                            ArrayList<String> temp = new ArrayList<>();
                            for (int j = 0; j <fdata.get(i).size() ; j++) {
                              temp.add(fdata.get(i).get(j));
                            }
                            rList.addAll(temp);
                        }

                        rList.add(s);

                        ArrayList<String> revertTool1 = new ArrayList<>();

                        for (int i = 0; i <revertTool.size() ; i++) {
                            ArrayList<String> temp = new ArrayList<>();
                            for (int j = 0; j <revertTool.get(i).size() ; j++) {
                                temp.add(revertTool.get(i).get(j));
                            }
                            revertTool1.addAll(temp);
                        }



                        for(int a=0; a<rList.size(); a++) {
                           recertIt(rList.get(a), revertTool1);
                        }

                    }

                }
            }



        }

    }



    private void recertIt(String filepath, ArrayList<String> revertTool){
        File revertFile = new File(filepath);
        System.out.println(filepath);
        if (Objects.requireNonNull(revertFile.listFiles()).length != 0) {
            File[] revertContent = revertFile.listFiles();

            ArrayList<File> revertContent1 =new ArrayList<>();
            for (int i = 0; i <revertContent.length ; i++) {
                System.out.println(revertTool.contains(revertContent[i].getAbsolutePath())+" "+revertContent[i].getAbsolutePath());
                if(revertTool.contains(revertContent[i].getAbsolutePath())){
                  revertContent1.add(revertContent[i]);
              }
            }


            for (int i = 0; i <revertContent1.size() ; i++) {

                File contentFile = revertContent1.get(i);

                System.out.println(contentFile.getName());

                if(Objects.requireNonNull(contentFile.listFiles()).length != 0) {
                    File[] asp = contentFile.listFiles();
                    System.out.println(Arrays.toString(asp));

                    for (int k = 0; k < asp.length; k++) {
                        File cv = asp[k];
                        System.out.println(filepath + File.separator + cv.getName());

                        cv.renameTo(new File(filepath + File.separator + cv.getName()));

//                        Files.move(cv.getAbsolutePath(),filepath + File.separator + cv.getName(), new StandardCopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                    }
                }

                contentFile.delete();
            }
        }

    }

    private ArrayList<ArrayList<String>> fillList(ArrayList<ArrayList<String>> c, String s, FileFunctions op){


        File[]  fas = op.readSFile(s);

        if(fas==null){}else {
            ArrayList<String> c1 = new ArrayList<>();
            if (fas.length != 0) {
                for (int i = 0; i < fas.length; i++) {
                    c1.add(String.valueOf(fas[i]));
                }

                c.add((ArrayList<String>) c1);
            }
        }
       return c;
    }


    private void doSub(String s,ArrayList<ArrayList<String>> data ){

        FileFunctions op2 = new FileFunctions();

        data = fillList(data, s, op2);

        ArrayList<String> f = new ArrayList<>();
        for (int i = 0; i <data.get(data.size()-1).size() ; i++) {
            if(new File(String.valueOf(data.get(data.size()-1).get(i))).isDirectory()){
              f.add(String.valueOf(data.get(data.size()-1).get(i)));
            }
        }

        if(!f.isEmpty()) {
            fdata.add(f);
        }
    }


    private ArrayList<String> doCurrentF(String s, FileFunctions op){

        ArrayList<String> revertTool = new ArrayList<>();

        op = new FileFunctions();

        File f = new File(s);


        String[] fAmount;
        String[] files = f.list();

        String[] paths;

        if (files == null) {
        } else {
            if (files.length != 0) {
                paths = new String[files.length];
                for (int i = 0; i < files.length; i++) {
                    String ft = files[i];
                    paths[i] = s + File.separator;
                    paths[i] = paths[i] + ft;
                }

                fAmount = op.getExtentions(files, paths).toArray(new String[0]);

                revertTool = op.move(paths, fAmount, s);
            }
        }

//        System.out.println(".doc");

        return revertTool;
    }


    private ArrayList<ArrayList<String>> doCurrent(String s, FileFunctions op, String number) {

        ArrayList<ArrayList<String>> revertTool = new ArrayList<>();

        //organize by file type
        if(number.equals("Organize by Type (Documents, Pictures , etc)")){

            op = new FileFunctions();

            File f = new File(s);


            String[] fAmount;
            String[] filesT = f.list();
            ArrayList<String> st = new ArrayList<>();

            if(filesT==null){}else{

                for (int i = 0; i < filesT.length; i++) {
                    if (new File(s + File.separator + filesT[i]).isDirectory()) {
                    } else {
                        st.add(filesT[i]);
                    }
                }

//                System.out.println(Arrays.toString(st.toArray()) + "herein Docs");

                String[] files = new String[st.size()];

                for (int i = 0; i <files.length ; i++) {
                    files[i] = st.get(i);
                }


                String[] paths;
                if (files.length != 0) {
                    paths = new String[files.length];
                    for (int i = 0; i < files.length; i++) {
                        String ft = files[i];
                        paths[i] = s + File.separator;
                        paths[i] = paths[i] + ft;
                    }

                    revertTool.add(op.makeIt(files,paths, s));

                }
            }
//            System.out.println("Documents");

         //organize by format
        }else if(number.equals("Organize by format (.doc , .jpg , etc)")) {

            revertTool.add(doCurrentF(s,new FileFunctions()));

        }

//        System.out.println(Arrays.toString(revertTool.toArray()));

        return revertTool;
    }


    public static void main(String[] args) {

        long s = System.currentTimeMillis();

        Main m =  new Main();

        long s1 = System.currentTimeMillis();
//
//
        System.out.println((s1-s));
        System.exit(0);

    }
}


