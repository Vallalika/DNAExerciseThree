import edu.duke.StorageResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

    PartOne partOne;
    int startIndex;
    String stopCodon;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // create a new output stream called outContent
    private final PrintStream originalOut = System.out; // assign standard output stream to originalOut variable

    @Before
    public void before() {
        System.setOut(new PrintStream(outContent)); // assign outContent to be tbe new output stream
        partOne = new PartOne();
        startIndex = 0;
        stopCodon = "TGA";

    }

    @Test
    public void canFindStopCodon(){
        //            ATG     TGA     TGA  TGA
        String dna = "ATGATCGCTGATTAGGTGACGTGATGACG";
        assertEquals(21,partOne.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void noStopCodon() {
        String dna = "ATGATCGCTGGTTAGGCTTATATACCG";
        assertEquals(dna.length(),partOne.findStopCodon(dna, startIndex, stopCodon));
    }

    @Test
    public void canFindValidGene() {
        String dna = "ATGATCGCTGATTATGTGACGTGATAAGACG";
        assertEquals("ATGATCGCTGATTATGTGACGTGA", partOne.findGene(dna));

    }

    @Test
    public void canNotFindValidGene() {
        String dna = "ATGATCGCTAATCATCTCACGTCATACGACG";
        assertEquals("", partOne.findGene(dna));

    }

    @Test
    public void canNotFindValidGeneTwo() {
        String dna = "ATCATCGCTAATCATCTCACGTCATACGACG";
        assertEquals("", partOne.findGene(dna));

    }

    @Test
    public void canAssertOutputValue() {
        System.out.println("This line is printed");
        assertEquals("This line is printed", outContent.toString().trim());
    }


    @Test
    public void noValidGene() {
//                    ATG     TGA     TGA
        String dna = "ATGATCGCTGATTATGTGACGTTATATGCCG";
        assertEquals("", partOne.findGene(dna));

    }

    @Test
    public void canPrintAllCorrectGenes() {
//                    ATG     TGA          TGA   ATG    TGA     TGA   ATGTGA
        String dna = "ATGATCGCTGATTATGTGACGTGACTAATGACGATGATCGCTTGACTTATGTGACGTGATAAGACG";
        partOne.printAllGenes(dna);
        assertEquals("ATGATCGCTGATTATGTGACGTGA" + "\n" +
                "ATGACGATGATCGCTTGA" + "\n" + "ATGTGA",outContent.toString().trim());
    };

    @Test
    public void canPrintAllCorrectGenesTwo() {
        //               ATG     TGA     TGA  TGATAATG            TGA  ATGTGA  TGA
        String dna = "AAAATGATCGCTGATTATGTGACGTGATAATGACGATGATCGCTTGATTATGTGACGTGATAAGACG";
        partOne.printAllGenes(dna);
        assertEquals("ATGATCGCTGATTATGTGACGTGA" + "\n" +
                "ATGACGATGATCGCTTGA" + "\n" + "ATGTGA", outContent.toString().trim());
    }

    @Test
    public void canGetAllGenes() {
        String dna = "AAAATGATCGCTGATTATGTGACGTGATAATGACGATGATCGCTTGATTATGTGACGTGATAAGACG";
        StorageResource genes = new StorageResource();
        genes.add("ATGATCGCTGATTATGTGACGTGA");
        genes.add("ATGACGATGATCGCTTGA");
        genes.add("ATGTGA");
        assertEquals(genes, partOne.getAllGenes(dna));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut); // reassign originalOut to output stream
    }

}
