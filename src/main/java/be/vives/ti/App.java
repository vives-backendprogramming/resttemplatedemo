package be.vives.ti;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class App 
{

    private static final String REST_URI
            = "http://www.omdbapi.com/?s=star wars&apikey=ad524872";

    public static void main( String[] args )
    {
        RestTemplate restTemplate = new RestTemplate();

        // Stap 1: als String
        // ResponseEntity<String> result = restTemplate.getForEntity(REST_URI, String.class);
        // System.out.println(result);

        ResponseEntity<MovieResult> remr = restTemplate.getForEntity(REST_URI, MovieResult.class);
        MovieResult mr = remr.getBody();

        if (mr.getResponse().equals("True")){
            mr.getSearch().stream()
                    .filter(e -> Integer.parseInt(e.getYear())>2000)
                    .forEach(e-> System.out.println(e));
        }
        else {
            throw new RuntimeException("Ongeldige zoekterm");
        }
    }
}
