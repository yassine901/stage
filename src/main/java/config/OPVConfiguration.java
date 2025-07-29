package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import Models.services.OPVTransactionService;

@Configuration
@ComponentScan(basePackages = {"Models.services", "Models.controllers"})
public class OPVConfiguration {

    @Value("${opv.soap.url:http://localhost:8080/soap}")
    private String soapUrl;

    @Value("${opv.login:opvuser}")
    private String login;

    @Value("${opv.password:opvpass}")
    private String password;

    @Value("${opv.signature.key:defaultkey}")
    private String signatureKey;

    @Value("${opv.canal:WEB}")
    private String canal;

    /**
     * Configuration du marshaller JAXB pour SOAP (style encadrant)
     */
    @Bean
    public Jaxb2Marshaller opvMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("Models.soap:Models.entities");
        return marshaller;
    }

    /**
     * Bean principal du service de transaction OPV
     */
    @Bean
    @Primary
    public OPVTransactionService opvTransactionService() {
        return new OPVTransactionService();
    }

    public String getSoapUrl() { return soapUrl; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getSignatureKey() { return signatureKey; }
    public String getCanal() { return canal; }
}