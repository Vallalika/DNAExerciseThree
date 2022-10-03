
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PartTwoTest {

        PartTwo partTwo;

        @Before
        public void before() {
            partTwo = new PartTwo();

        }

        @Test
        public void testCgRatio() {
            String dna = "ATGCCATAG";
            assertEquals(0.4444444,partTwo.cgRatio(dna), 0.2);
        }

        @Test
        public void canCountCtg() {
            String dna = "CTGTGCCCCTGGTCTG";
            assertEquals(3, partTwo.countCtg(dna));
        }
}
