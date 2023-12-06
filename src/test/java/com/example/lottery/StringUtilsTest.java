package com.example.lottery;

import com.example.lottery.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StringUtilsTest {

    @InjectMocks
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {

    }

    @Nested
    @DisplayName("For getLast method")
    class GetLastTest {
        @BeforeEach
        void setUp() {
        }

        @Test
        @DisplayName("when call getLast then return expect")
        void getLast() {
            String actual =  stringUtils.getLast("123456",2) ;
            assertEquals("56",actual);
        }

        @Test
        @DisplayName("when call getFront then return expect")
        void getFront() {
            String actual =  stringUtils.getFront("123456",3) ;
            assertEquals("123",actual);
        }
    }

}
