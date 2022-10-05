import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Runner {

    public static void main(String[] args) {
//        FileResource fr = new FileResource("brca1line.fa");
//        String dna = fr.asString();
        StorageResource dnaStrands = new StorageResource();
        dnaStrands.add("ATGATCGCTGATTATGTGACGTGACTAATGACGATGATCGCTTGACTTATGTGACGTGATAAGACG");
        dnaStrands.add("ATGATGA");
        dnaStrands.add("ATGACGAGGACCGCGTGAATGAGCGCCGGCCCCGCGGCGTGATTATGTGATTTTTTTTTAA");
        dnaStrands.add("ATGTTTTGATTATGTGATTTTTTTTTAA");

        PartThree partThree = new PartThree();
        partThree.processGenes(dnaStrands);

    }
}
