package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectBinaryListFictionBook {
    /**
     * Ghi dữ liệu FictionBook vào file fictionBook.txt
     */
    public void writeObjectBinaryFic(String path, List<Book> list) {
        BufferedOutputStream bufferedOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            File filePath = new File(path);

            if (!filePath.exists()) {
                throw new FileNotFoundException("File ko tồn tại");
            }

            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            //Sử dụng ép kiểu book sang fictionBook
            for (int i=0;i<list.size();i++){
                if (list.get(i) instanceof FictionBook){
                    FictionBook fictionBook=(FictionBook)list.get(i);
                    objectOutputStream.writeObject(fictionBook);
                }
            }

//            for (FictionBook fictionBook : list) {
//                objectOutputStream.writeObject(fictionBook);
//            }

            bufferedOutputStream.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc dữ liệu từ file fictionBook.txt
     */
//    public List<FictionBook> readObjectBinaryFic(String path) {
//        List<FictionBook> fictionBookList = new ArrayList<>();
//        BufferedInputStream bufferedInputStream;
//        ObjectInputStream objectInputStream;
//        try {
//            File filePath = new File(path);
//            if (!filePath.exists()) {
//                throw new FileNotFoundException("File ko tồn tại");
//            }
//
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
//            objectInputStream = new ObjectInputStream(bufferedInputStream);
//
//            FictionBook fictionBook;
//            while ((fictionBook = (FictionBook) objectInputStream.readObject()) != null) {
//                fictionBookList.add(fictionBook);
//            }
//
//            bufferedInputStream.close();
//        } catch (FileNotFoundException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        } catch (EOFException e) {
//            System.out.println("Hết dữ liệu");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return fictionBookList;
//    }
}
