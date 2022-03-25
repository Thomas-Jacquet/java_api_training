package fr.lernejo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleTest {

    @Test
    void op() {
        Sample s_instance = new Sample();
        assertEquals(2, s_instance.op(Sample.Operation.ADD, 1, 1));
        assertEquals(1, s_instance.op(Sample.Operation.MULT, 1, 1));
    }

    @Test
    void fact() {
        Sample s_instance = new Sample();
        assertEquals(1, s_instance.fact(0));
        assertEquals(1, s_instance.fact(1));
        assertEquals(120, s_instance.fact(5));
        assertThrows(IllegalArgumentException.class, () -> s_instance.fact(-1));
    }
}
