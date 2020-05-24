package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectBinaryListProgramingBook {
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

    /**Đọc dữ liệu từ file programingBook.txt*/
//    public List<ProgrammingBook> readObjectBinaryPro(String path) {
//        List<ProgrammingBook> programmingBookList = new ArrayList<>();
//        BufferedInputStream bufferedInputStream;
//        ObjectInputStream objectInputStream = null;
//        try {
//            File filePath = new File(path);
//            if (!filePath.exists()) {
//                throw new FileNotFoundException("File ko tồn tại");
//            }
//
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
//            objectInputStream = new ObjectInputStream(bufferedInputStream);
//
//            ProgrammingBook programmingBook;
//            while ((programmingBook = (ProgrammingBook) objectInputStream.readObject()) != null) {
//                programmingBookList.add(programmingBook);
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
//        return programmingBookList;
//    }
}

