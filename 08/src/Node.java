import java.util.ArrayList;
import java.util.List;

class Node {
    private int childrenCount;
    private List<Node> children;
    private int metadataEntriesCount;
    private List<Integer> metadataEntries;

    Node(int childrenCount, int metadataEntriesCount) {
        this.childrenCount = childrenCount;
        children = new ArrayList<>();
        this.metadataEntriesCount = metadataEntriesCount;
        metadataEntries = new ArrayList<>();
    }

    void addChild(Node child) {
        children.add(child);
    }

    void addMetadataEntry(int metadataEntry) {
        metadataEntries.add(metadataEntry);
    }

    int getMetadataSum() {
        int sum = 0;
        for(Node child : children) {
            sum += child.getMetadataSum();
        }
        for(int i : metadataEntries) {
            sum += i;
        }
        return sum;
    }

    int getNodeValue() {
        int sum = 0;
        if(childrenCount == 0) {
            for(int i : metadataEntries) {
                sum += i;
            }
        } else {
            for(int i : metadataEntries) {
                if(i <= childrenCount) {
                    sum += children.get(i-1).getNodeValue();
                }
            }
        }
        return sum;
    }

    int getMetadataEntriesCount() {
        return metadataEntriesCount;
    }

    int getChildrenCount() {

        return childrenCount;
    }
}
