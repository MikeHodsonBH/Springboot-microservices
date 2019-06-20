package apps.junem3ta.springbootstarter.res;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
	
	@RequestMapping("/greetings")
	public String returnJsonResponse() {
		return "Hello There!!!";
	}
	
}

