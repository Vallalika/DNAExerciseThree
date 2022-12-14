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
    public void printsLongDnaSequenceAndIgnoresShortSequence() {
        sr.add("ATGATCGCTGATT");
        sr.add("ATGATCG");
        sr.add("ATGATCGCTGATTATGTGACATGATCGCTGATTATGTGACATGATCGCTGATTATGTTTTTGA");
        partThree.processGenes(sr);
        assertEquals("ATGATCGCTGATTATGTGACATGATCGCTGATTATGTGACATGATCGCTGATTATGTTTTTGA",outContent.toString().trim().substring(0,63));
    }

    @Test
    public void printsHighCgRatioNotLowCgRatio() {
        sr.add("ATTTAA");
        sr.add("ACGCGCGCGCGCGCGCGCGCGCGCGCGCG");
        partThree.processGenes(sr);
        assertEquals("ACGCGCGCGCGCGCGCGCGCGCGCGCGCG",outContent.toString().trim().substring(2, 31));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}