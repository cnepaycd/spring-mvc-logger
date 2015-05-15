package com.github.isrsal.logging;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveWordHandler {

    public static String hiddenPassword(String text, ArrayList<String> keys) {
        String keysText = "";
        if(keys.isEmpty()){
            return text;
        }else {
            keysText = StringUtils.join(keys, "|");
        }
        Pattern p = Pattern.compile("\"("+keysText+")\"\\s*:\\s*\"([^\"]+)\"");
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "\""+m.group(1)+"\"" + ":"+ "\"************\"");
        }
        return m.appendTail(sb).toString();
    }
}
