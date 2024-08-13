package com.example.Consume;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class NasaApiController {

    private static final String NASA_API_URL = "https://api.nasa.gov/planetary/apod?api_key=J3QlMqNxK84jeDNWX0UJJhEjJJCBJlU5bSobtp5n";
    
    
    
    /*Após dar o get pelo postman, recebemos o conteúdo da requisição pelo console
     * Link: http://localhost:8080/nasa/apod */
    
    /*Método para consumir API*/
    @GetMapping("/nasa/apod")
    public ResponseEntity<String> getApod() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(NASA_API_URL, String.class);
    /*Método para consumir API*/
        
        
        
        if (response.getStatusCode().is2xxSuccessful()) { /*se o codigo do status do response for sucesso == 200*/
            // Imprimindo a resposta no console
            System.out.println("Resposta da API da NASA:");
            System.out.println(response.getBody()); //informação no body da requisição

            // Retornando a resposta JSON para o usuário
            return ResponseEntity.ok(response.getBody());
        } else {
            System.out.println("Erro ao acessar a API: " + response.getStatusCode());

            return ResponseEntity.status(response.getStatusCode()).body("Erro ao acessar a API da NASA");
        }
    }
}
