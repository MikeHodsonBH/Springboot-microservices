package apps.junem3ta.springbootstarter.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/some/random/endpoint")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("Spring Boot Java","Spring Framework", "Spring Framework Description"),
				new Topic("Java","Core Java", "Core Java Description"),
				new Topic("Javascript","Javascript", "Javascript Description")
				);
	}
	
}
