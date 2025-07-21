package document_collaboration;

import java.util.*;

public class Document {
  private int docId;
  private int ownerId;
  private String title;
  private List<Version> versions;
  private int currentVersionId;
  private String baseContent;

  public Document(int docId, int ownerId, String title, String initialContent) {
    this.docId = docId;
    this.title = title;
    this.ownerId = ownerId;
    this.versions = new ArrayList<>();
    this.baseContent = initialContent;

    Version initialVersion = new Version(1, docId, 1, ownerId, 0);
    versions.add(initialVersion);
    this.currentVersionId = initialVersion.getId();
  }

  public Version createVersion(int authorId, List<Deltas> deltas) {
    int newVersionNumber = versions.size() + 1;
    int newVersionId = newVersionNumber;
    
    Version newVersion = new Version(newVersionId, docId, newVersionNumber, authorId, currentVersionId);
    
    for (Deltas delta : deltas) {
      newVersion.addDelta(delta);
    }
    
    versions.add(newVersion);
    currentVersionId = newVersionId;
    return newVersion;
    }

  public String getContentAtVersion(int versionId) {
    String result = baseContent;
    
    for (Version version : versions) {
        if (version.getVersionNumber() == 1) continue; 
        result = version.applyDeltas(result);
        if (version.getId() == versionId) {
            break;
        }
    }
    
    return result;
  }
}
