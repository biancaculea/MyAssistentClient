package my.client;

import my.client.Model.Person;
//import my.client.Model.Tichet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import my.client.Clients.client01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}


	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return  args->{
			Map<String, String> params1 = new HashMap<>();
			params1.put("firstname", "George");
			String uri1 = "http://localhost:8091/myAssistent/firstname/{firstname}";
			ResponseEntity<List<Person>> personResponse_01 = restTemplate.exchange(
					uri1, HttpMethod.GET,
					null, new ParameterizedTypeReference<List<Person>>(){}, params1);
			List<Person> lc1=personResponse_01.getBody();
			try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("D:/fisiereJ8/MyAssistent01.txt")))) {
				lc1.stream().map(art->"articol  by  firstname: "+art.toString()).forEach(pw::println);
			}catch (IOException e){
				System.out.println(e.toString());
			}

			Map<String,String> params2 = new HashMap<>();
			params2.put("email", "bianca_culea@yahoo.com");
			String uri2 ="http://localhost:8091//myAssistent/email/{email}/";
			ResponseEntity<List<Person>> personResponse02 =restTemplate.exchange(uri2, HttpMethod.GET,null,
					new ParameterizedTypeReference<List<Person>>(){},params2);
			List<Person> lc2 = personResponse02.getBody();
			try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("D:/fisiereJ8/MyAssistent02.txt")))) {
				lc2.stream().map(art->"articol  by  email: "+art.toString()).forEach(pw::println);
			}catch (IOException e){
				System.out.println(e.toString());
			}

			Map<String,String> params3 =new HashMap<>();
			params3.put("id", "1");
			String uri3 = "http://localhost:8091/myAssistent/id/{id}";
			ResponseEntity<List<Person>> personResponse03 = restTemplate.exchange(uri3, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Person>>(){}, params3);

			List<Person> lc3=personResponse03.getBody();

			try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("D:/fisiereJ8/MyAssistent03.txt")))) {
				lc3.stream().map(art->"articol  by  Id: "+art.toString()).forEach(pw::println);
			}catch (IOException e){
				System.out.println(e.toString());
			}

		};
	}


}
