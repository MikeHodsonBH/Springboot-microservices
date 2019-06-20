package apps.junem3ta.springbootstarter.topics;

public class Topic {
	
	private String id, name, description;
	
	/*No args constructor*/
	public Topic() {}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return description;
	}

	public void setDescrition(String description) {
		this.description = description;
	}

}
