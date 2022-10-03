
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PartTwoTest {

        PartTwo partTwo;
        int startIndex;
        String stopCodon;

        @Before
        public void before() {
            partTwo = new PartTwo();
            startIndex = 0;
            stopCodon = "TGA";

        }

        @Test
        public void testCgRatio() {
            String dna = "ATGCCATAG";
            assertEquals(0.4444444,partTwo.cgRatio(dna), 0.2);
        }

//        @Test
//        public void canCountCtg() {
//            String dna = "CTGTGCCCCTGGTCTG";
//            assertEquals(3,partOne.countCtg(dna));
//        }
}
