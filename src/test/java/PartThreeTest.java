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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void before() {
        partThree = new PartThree();
        sr = new StorageResource();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printsLongDnaSequence() {
        sr.add("ATGATCGCTGATT");
        sr.add("ATGATCG");
        sr.add("ATGATCGCTGATTATGTGAC");
        partThree.processGenes(sr);
        assertEquals("ATGATCGCTGATT" + "\n" +
                "ATGATCGCTGATTATGTGAC",outContent.toString().trim().substring(0,34));
    }
//
//    @Test
//    public void doesNotPrintShortDnaSequence() {
//        sr.add("ATGATGA");
//        partThree.processGenes(sr);
//        assertEquals("",outContent.toString().trim());
//    }
//
//    @Test
//    public void printsHighCgRatio() {
//        sr.add("ATGACGAGGACCGCGTGAATGAGCGCCGGCCCCGCGGCGTGATTATGTGATTTTTTTTTAA");
//        partThree.processGenes(sr);
//        assertEquals("ATGACGAGGACCGCGTGA" + "\n" +
//                "ATGAGCGCCGGCCCCGCGGCGTGA",outContent.toString().trim());
//    }
//
//    @Test
//    public void doesNotPrintLowCgRatio() {
//        sr.add("ATGTTTTGATTATGTGATTTTTTTTTAA");
//        partThree.processGenes(sr);
//        assertEquals("ATGACGAGGACCGCGTGA" + "\n" +
//                "ATGAGCGCCGGCCCCGCGGCGTGA",outContent.toString().trim());
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }
//}