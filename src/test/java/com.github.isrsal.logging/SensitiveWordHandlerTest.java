package com.github.isrsal.logging;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SensitiveWordHandlerTest {

    @Test
    public void testHiddenPassword() throws Exception {
        String text = "\"tradePwd\": \"123435\", \"zzz\":\"123435\", \"password\":\"123435\", \"xxx\":\"123435\",\"yyy\":\"123435\"";
        ArrayList<String> keys = new ArrayList<String>();
        keys.add("password");
        keys.add("tradePwd");
        String hiddenText = SensitiveWordHandler.hiddenPassword(text, keys);
        String expectedTest = "\"tradePwd\":\"************\", \"zzz\":\"123435\", \"password\":\"************\", \"xxx\":\"123435\",\"yyy\":\"123435\"";
        assertEquals(expectedTest, hiddenText);
    }
}