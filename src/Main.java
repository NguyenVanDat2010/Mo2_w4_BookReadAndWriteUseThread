import book.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Book {
    static List<ProgrammingBook> programmingBooks;
    static List<Book> fictionBooks;

    static {
        programmingBooks = new ArrayList<>();
        programmingBooks.add(new ProgrammingBook("bc01", "Code Complete 2", 250000.0, "Steve McConnell", "Java", "Spring MVC"));
        programmingBooks.add(new ProgrammingBook("bc02", "Yellow book", 110000.0, "Rob Miles", "C#", ".Net"));
        programmingBooks.add(new ProgrammingBook("bc03", "Peopleware ", 350000.0, "Tom DeMarco ", "Java", "Spring MVC"));
        programmingBooks.add(new ProgrammingBook("bc04", "Programming Pearls", 260000.0, "Jon Bentley", "Java", "Spring MVC"));
        programmingBooks.add(new ProgrammingBook("bc05", "Core HTML5 Canvas", 180000.0, "Steve McConnell", "HTML", "Browser"));

        fictionBooks = new ArrayList<>();
        fictionBooks.add(new FictionBook("The Selfish Gene", 250000.0, "Science book"));
        fictionBooks.add(new FictionBook("Origin of species", 350000.0, "Natural science books"));
        fictionBooks.add(new FictionBook("Guns germs and steel", 280000.0, "Human history book"));
        fictionBooks.add(new FictionBook("The grand design", 360000.0, "Cosmic science book"));
        fictionBooks.add(new FictionBook("Cosmos", 1890000.0, "cosmic book"));
    }

    public static void main(String[] args) {
        /**Đọc và ghi cho ProgrammingBook*/
        ObjectBinaryListProgramingBook binaryListProgramingBook = new ObjectBinaryListProgramingBook();
        String pathProgram = "programingBook.txt";
        //Ghi file
        binaryListProgramingBook.writeObjectBinaryPro(pathProgram, programmingBooks);

        //Đọc file
        ProgrammingBook programmingBook=new ProgrammingBook("programingBook.txt");
        Thread thread1=new Thread(programmingBook);
        thread1.start();

        /**Đọc và ghi cho FictionBook*/
        ObjectBinaryListFictionBook binaryListFictionBook = new ObjectBinaryListFictionBook();
        String pathFiction = "fictionBook.txt";

        //Ghi file
//        List<FictionBook> fictionBook = new ArrayList<>();
//        for (int i = 0; i < fictionBooks.size(); i++) {
//            if (fictionBooks.get(i) instanceof FictionBook) {
//                FictionBook book = (FictionBook) fictionBooks.get(i);
//                fictionBook.add(book);
//            }
//        }
//        binaryListFictionBook.writeObjectBinaryFic(pathFiction, fictionBook);

        binaryListFictionBook.writeObjectBinaryFic(pathFiction,fictionBooks);

        //Đọc file
        FictionBook fictionBook=new FictionBook("fictionBook.txt");
        Thread thread2=new Thread(fictionBook);
        thread2.start();

//        List<FictionBook> fictionBookList = new ArrayList<>();
//        fictionBookList = binaryListFictionBook.readObjectBinaryFic(pathFiction);
//        for (FictionBook fictionBook1 : fictionBookList) {
//            System.out.println(fictionBook1);
//        }
    }
}
