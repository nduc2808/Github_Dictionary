import java.io.IOException;
import java.util.ArrayList;

public class DictionaryCommandline {

    public static void showAllWords() {
        ArrayList<Word> hienThi = Dictionary.getWords();
        System.out.println("No" + "\t\t\t" + "English" + "\t\t\t" + "Vietnamese");
        for(int i = 1; i <= hienThi.size(); i++) {
            System.out.println(i + "\t\t\t" + hienThi.get(i).getWord_target() + "\t\t\t" + hienThi.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommanline();
        showAllWords();
    }

    public static void dictionaryAdvanced() throws IOException {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }

}
