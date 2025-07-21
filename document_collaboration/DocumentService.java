package document_collaboration;
import java.util.*;

public class DocumentService {
    private Map<Integer, Document> documents;
    private int nextDocId = 1;
    public DocumentService() {
        this.documents = new HashMap<>();
    }
    
    public Document createDocument(String title, int ownerId, String initialContent) {
        int docId = nextDocId++;
        Document document = new Document(docId, ownerId, title, initialContent);
        documents.put(docId, document);
        return document;
    }
    
    public Document updateDocument(int docId, int userId, List<Deltas> deltas) {
        Document document = documents.get(docId);
        if (document == null) {
            throw new RuntimeException("Document not found");
        }
        
        document.createVersion(userId, deltas);
        return document;
    }
    
    public Document getDocument(int docId, int userId) {
        Document document = documents.get(docId);
        if (document == null) {
            throw new RuntimeException("Document not found");
        }
        
        return document;
    }
}