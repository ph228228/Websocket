package com.example;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public static void main(String[] args) {
        ImmutableMap<String, String> errorCodeMap = null;
        try {
            Properties prop = PropertiesLoaderUtils.loadAllProperties("compiler.properties");
            errorCodeMap = Maps.fromProperties(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(errorCodeMap);

    }




}
