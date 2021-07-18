package FileOrganizer;

import java.util.Arrays;

public class ExtManager{

    private String[] audio = {"mp3","wav",     "mid","mpa","ogg","cda","aif","wpl"}; //0-1
    private String[] video = {"mp4","wmv","mov","h264","3gp","avi","mkv","flv","m4v",     "3g2","mpg","mpeg","rm","swf","wob"};//0-7
    private String[] documents = {"xls","ppt","doc","pdf","txt","xlsx","pps","pptx","docx","xml",    "csv","ods","xlr","key"
            ,"odp","odt","rtf","onepkg",  "epub","tex","wks","wpd","dat","db","dbf","log","mdb","sav","sql","tar" , "mht" , "one"};//0-10
    private String[] pictures = {"jpg","jpeg","CR2","png","gif","bmp", "psd","HEIC","svg","tif",    "tiff","ai","ico","ps","JPG" , "PNG"};//0-8
    private String[] systemfiles = {"sys","iso","tmp","bin","dll","dmg","ttf",  "bak","cab","cfg","cpl","cur","dmp","drv",
             "icns", "ico", "ini", "kkk", "msi","toast","vcd","fnt","fon","otf"};//0-6
    private String[] internet = {"html","css","xhtml","htm",  "torrent", "cgi","asp","com","cer","cfm","pl","part","rss"};//0-3
    private String[] programming = {"c","class","cpp","cs","h","java","py","swift"  ,"js","sh","jsp","php","vb","sml","CircuitProject", "icls" , "whl"};//0-7
    private String[] compressed = {"rar","zip","z",  "7z","arj","deb","pkg","rpm","gaz"};//0-2
    private String[] applications = {"exe","jar","apk",  "bat","gadget","wsf"};//0-3

    String[] getPictures1(){return Arrays.copyOfRange(pictures,0,10);}
    String[] getAudio1(){return Arrays.copyOfRange(audio,0,2);}
    String[] getVideo1(){return Arrays.copyOfRange(video,0,9);}
    String[] getDocuments1(){return Arrays.copyOfRange(documents,0,10);}

    String[] getApplications1(){return Arrays.copyOfRange(applications,0,3);}
    String[] getCompressed1(){return Arrays.copyOfRange(compressed,0,3);}

    String[] getProgramming1(){return Arrays.copyOfRange(programming,0,8);}
    String[] getSystemfiles1(){return Arrays.copyOfRange(systemfiles,0,7);}
    String[] getInternet1(){return Arrays.copyOfRange(internet,0,5);}



    String[] getPictures2(){return Arrays.copyOfRange(pictures,10,pictures.length);}
    String[] getAudio2(){return Arrays.copyOfRange(audio,2,audio.length);}
    String[] getVideo2(){return Arrays.copyOfRange(video,9,video.length);}
    String[] getDocuments2(){return Arrays.copyOfRange(documents,10,documents.length);}

    String[] getApplications2(){return Arrays.copyOfRange(applications,3,applications.length);}
    String[] getCompressed2(){return Arrays.copyOfRange(compressed,3,compressed.length);}

    String[] getSystemfiles2(){return Arrays.copyOfRange(systemfiles,7,systemfiles.length);}
    String[] getInternet2(){return Arrays.copyOfRange(internet,5,internet.length);}
    String[] getProgramming2(){return Arrays.copyOfRange(programming,8,programming.length);}



//    ExtManager ex = new ExtManager();
//        System.out.println(Arrays.toString(ex.getAudio1()));
//        System.out.println(Arrays.toString(ex.getVideo1()));
//        System.out.println(Arrays.toString(ex.getDocuments1()));
//        System.out.println(Arrays.toString(ex.getPictures1()));
//        System.out.println(Arrays.toString(ex.getSystemfiles1()));
//        System.out.println(Arrays.toString(ex.getInternet1()));
//        System.out.println(Arrays.toString(ex.getProgramming1()));
//        System.out.println(Arrays.toString(ex.getCompressed1()));
//        System.out.println(Arrays.toString(ex.getApplications1()));
//
//        System.out.println();
//        System.out.println();
//
//        System.out.println(Arrays.toString(ex.getAudio2()));
//        System.out.println(Arrays.toString(ex.getVideo2()));
//        System.out.println(Arrays.toString(ex.getDocuments2()));
//        System.out.println(Arrays.toString(ex.getPictures2()));
//        System.out.println(Arrays.toString(ex.getSystemfiles2()));
//        System.out.println(Arrays.toString(ex.getInternet2()));
//        System.out.println(Arrays.toString(ex.getProgramming2()));
//        System.out.println(Arrays.toString(ex.getCompressed2()));
//        System.out.println(Arrays.toString(ex.getApplications2()));

}
