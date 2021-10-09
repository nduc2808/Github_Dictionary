import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static Object Word;

    public static void insertFromCommanline() {

        System.out.println("Nhap so luong tu vung: ");
        int soLuongTu = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuongTu; i++) {
            System.out.println("Nhap tu vung tieng Anh: ");
            String tuTiengAnh = scanner.nextLine();
            System.out.println("Nhap tu vung tieng Viet: ");
            String tuTiengViet = scanner.nextLine();

            Word element = new Word(tuTiengAnh, tuTiengViet);
            Dictionary.getWords().add(element);
        }
    }

    public static void insertFromFile() throws IOException {
        FileReader fileReader = new FileReader("dictionaries.txt");
        try {
            BufferedReader buffer = new BufferedReader(fileReader);
            String line = " ";
            while (true) {
                line = buffer.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("\t");
                String wordEng = txt[0];
                String wordVie = txt[1];
                Dictionary.getWords().add(new Word(wordEng, wordVie));
            }
        } catch (IOException checkbug) {
            checkbug.printStackTrace();
        }

    }

    public static void dictionaryLookup() {
        System.out.println("Nhap tu can tra: ");
        String tuCanTra = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            if (Dictionary.getWords().get(i).getWord_target().equalsIgnoreCase(tuCanTra)) {
                System.out.println("Nghia cua tu la: " + Dictionary.getWords().get(i).getWord_explain());
                k = 0;
            }
            else if (k == 1) {
                System.out.println("Xin vui long nhap lai!");
            }
        }
    }



    public static void main (String[]args) throws IOException {
//        insertFromCommanline();
        insertFromFile();
//        dictionaryLookup();
        DictionaryCommandline.showAllWords();
    }
}
