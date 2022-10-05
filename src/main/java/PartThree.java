import edu.duke.StorageResource;

public class PartThree {
    public void processGenes(StorageResource sr) {
        int longGeneCount = 0;
        int highCgCount = 0;
        String longestGene = "";

        PartOne partOne = new PartOne();

        for (String gene: sr.data()) {
            if (gene.length() > longestGene.length()) {
                longestGene = gene;
            }
            if ( gene.length() > 9 ) {
                longGeneCount += 1;
                System.out.println(gene);
            }
        }

        System.out.println(longGeneCount);

        PartTwo partTwo = new PartTwo();
        for (String gene: sr.data()) {
            if ( partTwo.cgRatio(gene) > 0.35 ) {
                highCgCount += 1;
                System.out.println(gene);
            }
        }

        System.out.println(highCgCount);
        System.out.println(longestGene);
    }
}