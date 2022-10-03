public class PartTwo {

    public float cgRatio(String dna) {
        float cgCount = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G' ) {
                cgCount += 1;
            }
        }
        return cgCount / dna.length();
    }
}
