import java.io.*;
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
        System.out.println("Nhập từ cần tra: ");
        String tuCanTra = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            if (Dictionary.getWords().get(i).getWord_target().equalsIgnoreCase(tuCanTra)) {
                System.out.println("Nghĩa của từ là: " + Dictionary.getWords().get(i).getWord_explain());
                k = 1;
            }
        }
        if (k == 0) {
            System.out.println("Xin vui lòng nhập lại!");
        }
    }

//    public static void adddata() {
//        System.out.println("Nhập nghĩa tiếng Anh: ");
//        String addwordEng = scanner.nextLine();
//        System.out.println("Nhập nghĩa tiếng Việt: ");
//        String addwordVie = scanner.nextLine();
//        Word addword = new Word(addwordEng,addwordVie);
//        Dictionary.getWords().add(addword);
//    }

//    public static void fixdata() {
//        System.out.println("Nhập từ tiếng Anh muốn sửa: ");
//        String wordtargetfix = scanner.nextLine();
//        System.out.println("Nhập từ tiếng Việt muốn sửa: ");
//        String wordexplainfix = scanner.nextLine();
//        System.out.println("Nhập từ tiếng Anh sửa: ");
//        String fixwordtarget = scanner.nextLine();
//        System.out.println("Nhập từ tiếng Việt sửa: ");
//        String fixwordexplain = scanner.nextLine();
//        for (int i = 0; i < Dictionary.getWords().size(); i++) {
//            if(Dictionary.getWords().get(i).getWord_target().equalsIgnoreCase(wordtargetfix)) {
////                Dictionary.getWords().get(i).getWord_target() = fixwordtarget;
//
//            } else if (Dictionary.getWords().get(i).getWord_explain().equalsIgnoreCase(wordVie)) {
//
//            }
//        }
//    }

//    public static void deletedata (){
//        System.out.println("Nhập từ tiếng Anh muốn xóa : ");
//        String deletewordEng = scanner.nextLine();
//        System.out.println("Nhập từ tiếng Việt muốn xóa : ");
//        String deletewordVie = scanner.nextLine();
//        Word deleteword = new Word(deletewordEng,deletewordVie);
//        Dictionary.getWords().remove(deleteword);
//    }

    public static void dictionaryExportToFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("dictionaries.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < Dictionary.getWords().size(); i++) {
                bufferedWriter.write(Dictionary.getWords().get(i).getWord_target() +
                        "\t" + Dictionary.getWords().get(i).getWord_explain());
            }
            fileWriter.close();
            bufferedWriter.close();
        } catch(IOException o) {
            o.printStackTrace();
        }
    }

    public static void main (String[]args) throws IOException {
//        insertFromCommanline();
        insertFromFile();
        dictionaryLookup();
//        dictionaryExportToFile();
        DictionaryCommandline.showAllWords();
    }
}
