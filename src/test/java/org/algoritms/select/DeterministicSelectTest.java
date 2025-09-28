package org.algoritms.select;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSelectBasic() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        DeterministicSelect selector = new DeterministicSelect();
        int result = selector.select(arr, 3);
        assertEquals(5, result);
        System.out.println("Comparisons: " + selector.getComparisons());
    }
}