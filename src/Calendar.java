//auxiliary class for implementing of XMLRPC-methods

import java.io.*;
import java.util.Vector;

public class Calendar {

    public int addEntry(String s){
        System.out.println("Adding entry...Done!");
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("Calendar.txt", true)));
            out.println(s);
        }catch (IOException e) {
            System.err.println(e);
        }finally{
            if(out != null){
                out.close();
            }
        }
        return 42;
    }

    public void deleteEntry(String s){
        System.out.println("Deleting entry...Done!");
        //search in file line by line
        //delete line
    }

//    public void modifyEntry(String s){
//        System.out.println("Modifying entry...Done!");
//    }

    public Vector getList(){
        //read from the file and create one string and send
        Vector result = new Vector();
        File file = new File("Calendar.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
