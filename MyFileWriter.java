import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class MyFileWriter {


     // Calculate and print the file size using the File class
    private static void printFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }


       /**
* Reads a text file and returns its contents as a string.
* 
* @param filePath the path to the file
* @return the contents of the file as a string
* @throws IOException if an I/O error occurs
*/
public static String stringify(String filePath) throws IOException {
     // TODO: Implement this method
     // Read the file at filePath and return its contents as a String
    StringBuilder content = new StringBuilder();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }

        return content.toString();

}



    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";
        String fileName6 = ".secretpassword.txt";
        String fileName7 = "noLookie.txt";

        MyFileWriter.printFileSize("\\\\wsl.localhost\\Ubuntu-20.04\\home\\beef\\FileWriterActivity\\sizer.txt");

       

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName6))) {
            bufferedWriter.write("a password");
        } catch (IOException e) {
            e.printStackTrace();
        }

           try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName7))) {
            bufferedWriter.write("confidential information");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyFileWriter.printFileSize("\\\\wsl.localhost\\Ubuntu-20.04\\home\\beef\\FileWriterActivity\\sizer.txt");

    }
}