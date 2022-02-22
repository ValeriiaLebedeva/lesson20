package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface MobileConfig extends Config {
    String user();

    String key();

    String appUrl();
}