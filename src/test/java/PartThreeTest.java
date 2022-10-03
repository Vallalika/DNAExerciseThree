import edu.duke.FileResource;
import edu.duke.StorageResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PartThreeTest {

    PartThree partThree;
    StorageResource sr;
    FileResource fr;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void before() {
        partThree = new PartThree();
        sr = new StorageResource();
        fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printsLongDnaSequence() {
        sr.add("ATGATCGCTGATTATGTGACGTGACTAATGACGATGATCGCTTGACTTATGTGACGTGATAAGACG");
        partThree.processGenes();
        assertEquals("ATGATCGCTGATTATGTGACGTGA" + "\n" +
                "ATGACGATGATCGCTTGA",outContent.toString().trim());
    }

    @Test
    public void doesNotPrintShortDnaSequence() {
        sr.add("ATGATGA");
        partThree.processGenes();
        assertEquals("",outContent.toString().trim());
    }

    @Test
    public void printsHighCgRatio() {
        sr.add("ATGACGAGGACCGCGTGAATGAGCGCCGGCCCCGCGGCGTGATTATGTGATTTTTTTTTAA");
        partThree.processGenes();
        assertEquals("ATGACGAGGACCGCGTGA" + "\n" +
                "ATGAGCGCCGGCCCCGCGGCGTGA",outContent.toString().trim());
    }

    @Test
    public void doesNotPrintLowCgRatio() {
        sr.add("ATGTTTTGATTATGTGATTTTTTTTTAA");
        partThree.processGenes();
        assertEquals("ATGACGAGGACCGCGTGA" + "\n" +
                "ATGAGCGCCGGCCCCGCGGCGTGA",outContent.toString().trim());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
