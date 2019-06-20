package apps.junem3ta.springbootstarter.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultErrorController implements ErrorController {
	
	public static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String handleError() {
		return "Under developement. Try out '/res' or '/topics' in the meanwhile :) !!";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
}
