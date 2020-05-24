package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FictionBook extends Book implements Serializable,Runnable {
    private String category;
    private String path;

    public FictionBook() {
    }

    public FictionBook(String path) {
        this.path = path;
    }

    public FictionBook(String category, String path) {
        this.category = category;
        this.path = path;
    }

    public FictionBook(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    public FictionBook(String bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "A book, There are name: " + super.getName() + ", Price: " + super.getPrice() + " and Category: " + getCategory();
    }

    @Override
    public void run() {
        List<FictionBook> fictionBookList = new ArrayList<>();
        BufferedInputStream bufferedInputStream;
        ObjectInputStream objectInputStream;
        try {
            File filePath = new File(path);
            if (!filePath.exists()) {
                throw new FileNotFoundException("File ko tồn tại");
            }

            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            objectInputStream = new ObjectInputStream(bufferedInputStream);

            FictionBook fictionBook;
            while ((fictionBook = (FictionBook) objectInputStream.readObject()) != null) {
                fictionBookList.add(fictionBook);
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
        System.out.println(fictionBookList);
    }
}
