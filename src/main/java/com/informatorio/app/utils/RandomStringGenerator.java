package com.informatorio.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class RandomStringGenerator {
    private static final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String generate() {
    	
        Random randomLength = new Random();
        int length = randomLength.nextInt(40 - 20) + 20;

        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }
    public static String generateCode() {
    	DateFormat df = new SimpleDateFormat("yy");

    	String fd= df.format(new Date());



        StringBuilder code = new StringBuilder();
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < 3; i++) {
            String upper = charCategories[1];
            code.append(upper.charAt(random.nextInt(upper.length())));
            code.append(upper.charAt(random.nextInt(upper.length())));    
        }
        code.append("-"+fd);
        return new String(code);
    }
}