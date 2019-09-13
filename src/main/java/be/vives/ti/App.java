package be.vives.ti;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String REST_URI
            = "http://www.omdbapi.com?s=godfather&apikey=ad524872";

    public static void main( String[] args )
    {
        RestTemplate restTemplate = new RestTemplate();

        // Stap 1: als String
        // ResponseEntity<String> s = restTemplate.getForEntity(REST_URI, String.class);
        // System.out.println(s);

        ResponseEntity<MovieResult> remr = restTemplate.getForEntity(REST_URI, MovieResult.class);
        MovieResult mr = remr.getBody();

        if (mr.getResponse().equals("True")){
            mr.getSearch().stream()
                    .filter(e -> Integer.parseInt(e.getYear())>1990)
                    .forEach(e-> System.out.println(e));
        }
        else {
            throw new RuntimeException("Ongeldige zoekterm");
        }
    }
}
