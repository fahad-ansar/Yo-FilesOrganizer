package FileOrganizer;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println(s);

            int n = JOptionPane.showConfirmDialog(new JFrame(),"Do you want to Organize subdirectories also?","Yo!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,new ImageIcon());


            String[] choices = {"Organize by format (.doc , .jpg , etc)", "Organize by Type (Documents, Pictures , etc)"};
            String number = (String) JOptionPane.showInputDialog(null, "Organization Type","Yo!", JOptionPane.QUESTION_MESSAGE, new ImageIcon(),choices, choices[1]); // Initial choice
            System.out.println(number);



            if(n == 1){
                FileFunctions op = new FileFunctions();
                doCurrent(s , op, number);

            }else if(n == 0){

                ArrayList<ArrayList<String>> data =  new ArrayList<>();

                doSub(s,data);


                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                        doSub(String.valueOf(fdata.get(i).get(j)), data);
                    }
                }

                FileFunctions op = new FileFunctions();
                doCurrent(s , op, number);


                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                        doCurrent(fdata.get(i).get(j), new FileFunctions(), number);
                    }
                }
                System.out.println("In subs");
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


    private void doCurrentF(String s, FileFunctions op){
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

                op.move(paths, fAmount, s + File.separator);
            }
        }

        System.out.println(".doc");

    }


    private void doCurrent(String s, FileFunctions op, String number) {


        if(number.equals("Organize by Type (Documents, Pictures , etc)")){

            op = new FileFunctions();

            File f = new File(s);


            String[] fAmount;
            String[] filesT = f.list();
            ArrayList<String> st = new ArrayList<>();

            if(filesT==null){}else {
                for (int i = 0; i < filesT.length; i++) {
                    if (new File(s + File.separator + filesT[i]).isDirectory()) {
                    } else {
                        st.add(filesT[i]);
                    }
                }

                System.out.println(Arrays.toString(st.toArray()));

                String[] files = new String[st.size()];

                for (int i = 0; i <files.length ; i++) {
                    files[i] = st.get(i);
                }

                System.out.println(Arrays.toString(files));

                String[] paths;
                if (files.length != 0) {
                    paths = new String[files.length];
                    for (int i = 0; i < files.length; i++) {
                        String ft = files[i];
                        paths[i] = s + File.separator;
                        paths[i] = paths[i] + ft;
                    }

                    op.makeIt(files,paths, s);
                    doCurrentF(s+File.separator+"Others", new FileFunctions());
                }
            }
            System.out.println("Documents");

        }else if(number.equals("Organize by format (.doc , .jpg , etc)")) {

            doCurrentF(s,new FileFunctions());
//            op = new FileFunctions();
//
//            File f = new File(s);
//
//
//            String[] fAmount;
//            String[] files = f.list();
//
//            String[] paths;
//
//            if (files == null) {
//            } else {
//                if (files.length != 0) {
//                    paths = new String[files.length];
//                    for (int i = 0; i < files.length; i++) {
//                        String ft = files[i];
//                        paths[i] = s + File.separator;
//                        paths[i] = paths[i] + ft;
//                    }
//
//                    fAmount = op.getExtentions(files, paths).toArray(new String[0]);
//
//                    op.move(paths, fAmount, s + File.separator);
//                }
//            }
//
//            System.out.println(".doc");
        }
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


