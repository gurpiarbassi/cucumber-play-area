package fruit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/fruit")
public class FruitController {

	@RequestMapping(value="/list", method = RequestMethod.GET, produces="application/json" )
	@ResponseBody
	public ResponseEntity<List<Fruit>> list(){
		
		List<Fruit> fruits = new ArrayList<>();
		
		Fruit yellowBanana = new Fruit();
		Fruit redStrawberry = new Fruit();
		yellowBanana.setColor("yellow");
		yellowBanana.setName("banana");
		redStrawberry.setColor("red");
		redStrawberry.setName("strawberry");
		
		fruits.add(yellowBanana);
		fruits.add(redStrawberry);
		
		return new ResponseEntity<List<Fruit>>(fruits, HttpStatus.OK);
	}
}
