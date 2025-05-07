import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Testing {
    private Map<String, Set<String>> index;  // word -> doc names
    private Map<String, String> documents;   // doc name -> content

    public Testing() {
        this.index = new HashMap<>();
        this.documents = new HashMap<>();
    }

    public void indexDocuments(String[] filenames) {
        for (String filename : filenames) {
            String content = readDocument(filename);
            if (!content.isEmpty()) {
                documents.put(filename, content);
                String[] words = content.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    index.computeIfAbsent(word, k -> new HashSet<>()).add(filename);
                }
            }
        }
    }

    private String readDocument(String filename) {
        StringBuilder content = new StringBuilder();
        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                content.append(reader.nextLine()).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find document: " + filename);
        }
        return content.toString().trim();
    }

    public List<String> search(String query) {
        String[] queryWords = query.toLowerCase().split("\\s+");
        Set<String> resultDocs = new HashSet<>();

        if (index.containsKey(queryWords[0])) {
            resultDocs.addAll(index.get(queryWords[0]));
        }

        for (int i = 1; i < queryWords.length; i++) {
            String word = queryWords[i];
            if (index.containsKey(word)) {
                resultDocs.retainAll(index.get(word));
            } else {
                resultDocs.clear();
                break;
            }
        }

        return new ArrayList<>(resultDocs);
    }
}
