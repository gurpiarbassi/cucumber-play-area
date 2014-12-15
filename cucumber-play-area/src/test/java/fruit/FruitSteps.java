package fruit;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FruitSteps {

	private String response;
	
	@Given("^the system knows about the following fruit:$")
	public void theSystemKnowsAboutTheFollowingFruit(List<Fruit> fruitList)
			throws Throwable {
		Gson gson = new Gson();
		PrintWriter writer = new PrintWriter("fruit.json", "UTF-8");
		writer.println(gson.toJson(fruitList));
		writer.close();
	}

	@When("^the client requests GET /fruits$")
	public void theClientRequestsGETFruits() throws Throwable {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Fruit>> resp = restTemplate.exchange("http://localhost:8080/service/fruit/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Fruit>>() {});
		Gson gson = new Gson();
		this.response = gson.toJson(resp.getBody());
        
		assertEquals("Did not receive OK response: ",
				String.valueOf(HttpURLConnection.HTTP_OK), resp.getStatusCode().toString());
		
	}

	@Then("^the response should be JSON:$")
	public void theResponseShouldBeJSON(String jsonExpected) throws Throwable {
		JsonParser parser = new JsonParser();
		
		//when comparing json its best to parse it first since string comparison may have things like spaces, line breaks e.t.c
		assertEquals("Incorrect JSON representation.",
				parser.parse(jsonExpected), parser.parse(response));
		
	}
	
	
}
