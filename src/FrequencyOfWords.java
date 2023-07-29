import java.util.HashMap;
public class FrequencyOfWords {
    private static class MyMapNode {
        String word;
        int frequency;

        public MyMapNode(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        String sentence = "To be or not to be";
        HashMap<String, MyMapNode> hashMap = new HashMap<>();

        for (String word : sentence.split(" ")) {
            MyMapNode myMapNode = hashMap.get(word);

            if (myMapNode == null) {
                myMapNode = new MyMapNode(word, 0);
            }

            myMapNode.frequency++;
            hashMap.put(word, myMapNode);
        }

        for (String word : hashMap.keySet()) {
            System.out.println(word + " : " + hashMap.get(word).frequency);
        }
    }
}
