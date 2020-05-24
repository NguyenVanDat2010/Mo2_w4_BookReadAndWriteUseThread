package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingBook extends Book implements Serializable,Runnable {
    private String language;
    private String framework;
    private String path;

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
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Hết dữ liệu");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(programmingBookList);
    }
}
