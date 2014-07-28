package no.nith.sivpal12.futurama.quotes.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VersionController {

    private static final String VERSION_PROPERTY_KEY = "version";
    private static final String APP_PROPERTIES = "target/classes/app-description.properties";
    private static final Logger LOG = LogManager.getLogger();
    private String VERSION;

    @RequestMapping("/version")
    public @ResponseBody String getAppVersion() {
        if (VERSION == null) {
            Properties properties = new Properties();
            try (InputStream in = new FileInputStream(APP_PROPERTIES)) {
                properties.load(in);
            } catch (FileNotFoundException e) {
                LOG.error(String.format("File {%s} not found!", APP_PROPERTIES));
            } catch (IOException e) {
                LOG.error("Unknown expetion (IOException)", e);
            }
            VERSION = properties.getProperty(VERSION_PROPERTY_KEY);
        }
        return VERSION;
    }
}
