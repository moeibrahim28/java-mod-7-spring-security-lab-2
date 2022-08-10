package com.example.SpringUnitTesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PriceController {

    private final CryptoService cryptoService;

    public PriceController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto/{crypto}")
    public String price(@PathVariable String crypto) {
        StringBuilder coinPage = new StringBuilder();
        coinPage.append("<h2>Price of " + crypto + " is currently: " + cryptoService.getCryptoPrice(crypto) + "<br></h2>");
        coinPage.append("<select name=\"forma\" onchange=\"location = this.value;\" style=\"padding: 40px; background-color:paleturquoise; border:none;\"> ");
        coinPage.append("<option value=\"http://localhost:8080/\">(select an option)</option>");
        coinPage.append("<option value=\"http://localhost:8080/\">Home</option>");
        coinPage.append("<option value=\"http://localhost:8080/crypto/bitcoin\">Bitcoin</option>)");
        coinPage.append("<option value=\"http://localhost:8080/crypto/usd-coin\">USD-COIN</option>");
        coinPage.append("<option value=\"http://localhost:8080/crypto/tether\">Tether</option>");
        coinPage.append("<option value=\"http://localhost:8080/crypto/ethereum\">Ethereum</option>");
        coinPage.append("<option value=\"http://localhost:8080/crypto/cardano\">Cardano</option>");
        coinPage.append("<option value=\"http://localhost:8080/crypto/solana\">Solana</option></select>");


        return coinPage.toString();
    }

}