import java.util.List;

public class testMain {
    public static void main(String[] args) {
        Testing searchEngine = new Testing();

        // Tell it which files to index
        String[] files = {"Doc1.txt", "Doc2.txt", "Doc3.txt"};
        searchEngine.indexDocuments(files);

        // Perform a search
        List<String> results = searchEngine.search("momol");
        System.out.println("Documents containing 'momol': " + results);
    }
}
