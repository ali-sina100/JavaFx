package practicingPolymorphism;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DialogExample {
    public static void main(String[] args) throws IOException {
        File f = new File("names.text");
        FileWriter writer = new FileWriter(f);
        Scanner sc = new Scanner(f);
        if(!f.exists()) {
            f.createNewFile();
            System.out.println("new file created !");
        }
        else if(f.exists()) {
            System.out.println("file already exists !");
        }
        for(int i = 0; i < 1000; i ++){
            writer.write(" \"" + i + "\" \n");
        }

        writer.close();
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
        System.out.println("the text exracted from : " + f.getName());
    }
}