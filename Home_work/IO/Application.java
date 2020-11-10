package Home_work.IO;

import java.io.*;

public class Application {

    public static void main(String[] args) {
        File file = new File("sources/file111.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (IODecorator ioDecorator = new IODecorator(new BufferedOutputStream(
                new FileOutputStream(file)))) {
            ioDecorator.write("Hello, World!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputDecorator inputDecorator = new InputDecorator(new FileInputStream(file))) {
            byte[] fileInArray = new byte[(int) file.length()];
            inputDecorator.read(fileInArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
