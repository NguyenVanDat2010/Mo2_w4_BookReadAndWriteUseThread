package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingBook extends Book implements Runnable {
    private String language;
    private String framework;
    private String path;
    private List<ProgrammingBook>list=new ArrayList<>();

    public ProgrammingBook() {
    }

    public ProgrammingBook(String path) {
        this.path = path;
    }

    public ProgrammingBook(String language, String framework) {

        this.language = language;
        this.framework = framework;
    }

    public ProgrammingBook(String name, double price, String language) {
        super(name, price);
        this.language = language;
    }

    public ProgrammingBook(String bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public String toString() {

        return super.toString() + ", Language: " + getLanguage() + " and Framework: " + getFramework();
    }

    /**Ghi dữ liệu ProgrammingBook vào file programingBook.txt*/
    public void writeObjectBinaryPro(String path, List<ProgrammingBook> list) {
        BufferedOutputStream bufferedOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            File filePath = new File(path);

            if (!filePath.exists()) {
                throw new FileNotFoundException("File ko tồn tại");
            }

            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            for (ProgrammingBook programmingBook : list) {
                objectOutputStream.writeObject(programmingBook);
            }

            bufferedOutputStream.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        List<ProgrammingBook> programmingBookList = new ArrayList<>();
        BufferedInputStream bufferedInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            File filePath = new File(path);
            if (!filePath.exists()) {
                throw new FileNotFoundException("File ko tồn tại");
            }

            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            objectInputStream = new ObjectInputStream(bufferedInputStream);

            ProgrammingBook programmingBook;
            while ((programmingBook = (ProgrammingBook) objectInputStream.readObject()) != null) {
                programmingBookList.add(programmingBook);
            }
            bufferedInputStream.close();

        } catch (EOFException e) {
            System.out.println("Hết dữ liệu");
        } catch (ClassNotFoundException | IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println(programmingBookList);
    }
}
