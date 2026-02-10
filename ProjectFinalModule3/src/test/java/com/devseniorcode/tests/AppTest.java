package com.devseniorcode.tests;

import com.devseniorcode.App;
import com.devseniorcode.exceptions.OptionInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testExitApp() {
        assertDoesNotThrow(() -> App.applyOperation((short) 5));
    }

    @Test
    void testOptionInvalid() {
        assertThrows(OptionInvalidException.class, () -> App.applyOperation((short) 6));
    }
}