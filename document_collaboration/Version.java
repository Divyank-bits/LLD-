package document_collaboration;

import java.util.*;

public class Version {
  private int vid;
  // private String id;
    private int docId;
    private int versionNumber;
    private int uId;
    private int parentVersionId;
    private List<Deltas> deltas;
  // List<Deltas> deltas;

  public Version (int vid, int docId, int versionNumber, int uId, int parentVersionId) {
    this.vid = vid;
    this.docId = docId;
    this.versionNumber = versionNumber;
    this.uId = uId;
    this.parentVersionId = parentVersionId;
    deltas = new ArrayList<>(deltas);
  }

  public void addDelta( Deltas d) {
    deltas.add(d);
  }

  public String applyDeltas(String baseContent) {
    String str = baseContent;
    for(Deltas d: deltas) {
      str = d.apply(baseContent);
    }
    return str;
  }
  public int getId() { return vid; }
  public int getVersionNumber() { return versionNumber;}
}
