package com.sity.msmpesaservice.utils;

import lombok.extern.slf4j.Slf4j;
import java.nio.charset.StandardCharsets;
import org.bson.internal.Base64;


@Slf4j
public class HelperUtility {
    public static String toBase64String(String value){
        byte[] data = value.getBytes(StandardCharsets.ISO_8859_1);
        String encoded = Base64.encode(data);
        log.info(encoded);
        return encoded;
    }
}
