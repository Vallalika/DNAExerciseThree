import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Runner {

    public static void main(String[] args) {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();
        PartOne partOne = new PartOne();
        StorageResource allGenes = partOne.getAllGenes(dna);
        PartThree partThree = new PartThree();
        partThree.processGenes(allGenes);
    }

}