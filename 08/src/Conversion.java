import java.util.List;

class Conversion {
    static Node numbersListToTree(List<Integer> numbers) {
        Node root = new Node(numbers.get(0), numbers.get(1));
        numbers.remove(0);
        numbers.remove(0);
        for (int i = 0; i < root.getChildrenCount(); i++) {
            root.addChild(Conversion.numbersListToTree(numbers));
        }
        for (int i = 0; i < root.getMetadataEntriesCount(); i++) {
            root.addMetadataEntry(numbers.get(0));
            numbers.remove(0);
        }
        return root;
    }
}
