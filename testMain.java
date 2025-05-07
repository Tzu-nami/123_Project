import java.util.List;

public class testMain {
    public static void main(String[] args) {
        Testing searchEngine = new Testing();

        String[] files = {"Doc1.txt", "Doc2.txt", "Doc3.txt"};
        searchEngine.indexDocuments(files);

        List<String> results = searchEngine.search("momol");
        System.out.println("Documents: " + results);
    }
}
