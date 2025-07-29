package Models.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebInterfaceController {

    @Value("${server.port:8080}")
    private String serverPort;

    @GetMapping("/")
    public String home(Model model) {
        String baseUrl = "http://localhost:" + serverPort;

        model.addAttribute("pageTitle", "Transaction Processor - SOAP");
        model.addAttribute("environment", "DEVELOPMENT");
        model.addAttribute("version", "v2.0");
        model.addAttribute("defaultEndpoint", baseUrl + "/position/v2/transactionProcessor"); // Port dynamique
        model.addAttribute("defaultCertificat", "AZERTYPUI2018AWB");
        model.addAttribute("defaultUser", "opvuser");
        model.addAttribute("defaultPassword", "pa123456");
        model.addAttribute("defaultAccount", "001234567890123");
        model.addAttribute("defaultAmount", "50000");
        model.addAttribute("apiBase", baseUrl); // AJOUT: Pour l'API

        return "transaction-interface";
    }

    @GetMapping("/test")
    public String testInterface(Model model) {
        String baseUrl = "http://localhost:" + serverPort;

        model.addAttribute("pageTitle", "Interface de Test");
        model.addAttribute("environment", "TEST");
        model.addAttribute("defaultEndpoint", baseUrl + "/position/v2/transactionProcessor");
        model.addAttribute("apiBase", baseUrl);

        return "transaction-interface";
    }

    @GetMapping("/interface")
    public String transactionInterface(Model model) {
        String baseUrl = "http://localhost:" + serverPort;

        model.addAttribute("pageTitle", "Interface Transactions");
        model.addAttribute("environment", "PRODUCTION");
        model.addAttribute("defaultEndpoint", baseUrl + "/position/v2/transactionProcessor");
        model.addAttribute("apiBase", baseUrl);

        return "transaction-interface";
    }


}