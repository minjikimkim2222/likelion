package ch01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleTest {

    @Test
    void findMiddle(){
        int result = MiddleValue.findMiddle(4,1,6);
        Assertions.assertEquals(4, result);
    }
}
