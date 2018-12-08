public class Main {
    public static void main(String[] args) {
        Node tree = Conversion.numbersListToTree(ReadFile.getNumbers());
        System.out.println("1: " + tree.getMetadataSum());
        System.out.println("2: " + tree.getNodeValue());
    }
}
