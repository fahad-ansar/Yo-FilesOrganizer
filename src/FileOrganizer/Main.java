package FileOrganizer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javafx.application.ConditionalFeature.SWT;
import static javax.swing.UIManager.get;

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
            String s = select.getAbsolutePath();

            int n =1;


            if(n == 0){
                FileFunctions op = new FileFunctions();
                doCurrent(s , op);

            }else if(n == 1){

                ArrayList<ArrayList<String>> data =  new ArrayList<>();

                doSub(s,data);


                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                        doSub(String.valueOf(fdata.get(i).get(j)), data);
                    }
                }

                FileFunctions op = new FileFunctions();
                doCurrent(s , op);


                for (int i = 0; i <fdata.size() ; i++) {
                    for (int j = 0; j < fdata.get(i).size() ; j++) {
                        doCurrent(fdata.get(i).get(j), new FileFunctions());
                    }
                }

            }
            System.exit(0);
        }

    }





    private ArrayList<ArrayList<String>> fillList(ArrayList<ArrayList<String>> c, String s, FileFunctions op){
        ArrayList<String> c1 = new ArrayList<>();

        String[]  fas = op.readSFile(s);

        for (int i = 0; i <fas.length ; i++) {
            c1.add(String.valueOf(fas[i]));
        }


        for (int i = 0; i <c1.size() ; i++) {
            c1.set(i, s + File.separator + c1.get(i));
        }

       c.add((ArrayList<String>) c1);
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


    private void doCurrent(String s, FileFunctions op) {


        String[] fAmount;
        String[] files ;
        String[] paths;

        op = new FileFunctions();

        File f = new File(s);


        files = f.list();


        if(files.length!=0) {
            paths = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                String ft = files[i];
                paths[i] = s + File.separator;
                paths[i] = paths[i] + ft;
            }

            fAmount = op.getExtentions(files, paths).toArray(new String[0]);

            op.makeFolder(fAmount, s + File.separator);

            op.move(paths, fAmount, s + File.separator);
        }
    }

    public static void main(String[] args) {
	  Main m =  new Main();
    }
}
