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

    public int countCtg(String dna) {
        String dnaStrand = dna;
        int ctgCount = 0;
        while (true) {
            int ctgIndex = dnaStrand.indexOf("CTG");
            if (ctgIndex != -1) {
                ctgCount += 1;
                dnaStrand = dnaStrand.substring(ctgIndex + 3);
            } else {
                break;
            }
        }
        return ctgCount;
    }
}
