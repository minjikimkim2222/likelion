package ch01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxValueTest {

    @Test
    void findMax(){
        int result = MaxValue.findMax(4,5,6);
        Assertions.assertEquals(6, result);

        Assertions.assertEquals(5, MaxValue.findMax(4,4,5));

        Assertions.assertEquals(4, MaxValue.findMax(4,4,4));

        Assertions.assertEquals(100, MaxValue.findMax(4,100,-9));
    }
}
