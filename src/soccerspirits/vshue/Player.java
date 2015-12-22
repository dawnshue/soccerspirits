package soccerspirits.vshue;


public class Player {

	public final static int NUM_FIELDS = 5;

	public enum Element {
		FIRE, WIND, THUNDER, LIGHT, DARK
	}

	private String name;
	private boolean isHas;
	private int stars;
	private Element element;
	private boolean isEvent;
	private String story;

	public Player(String[] fields) {
		this(fields[0], Integer.parseInt(fields[1]), Integer
				.parseInt(fields[2]), fields[3], Integer.parseInt(fields[4]),
				fields[5]);
	}

	public Player(String name, int isHas, int stars, String element,
			int isEvent, String story) {
		this.name = name.toUpperCase();

		if (isHas < 0 || isHas > 1) {
			throw new IllegalArgumentException("Have value cannot be " + isHas);
		}
		this.isHas = (isHas == 1);

		if (stars < 1 || stars > 6) {
			throw new IllegalArgumentException("Cannot have " + stars
					+ " stars.");
		}
		this.stars = stars;

		setElement(element);

		if (isEvent < 0 || isEvent > 1) {
			throw new IllegalArgumentException("Event value cannot be " + isHas);
		}
		this.isEvent = (isEvent == 1);

		this.story = story;
	}

	private void setElement(String element) {
		switch (element) {
		case "FIRE":
			this.element = Element.FIRE;
			break;
		case "WIND":
			this.element = Element.WIND;
			break;
		case "THUNDER":
			this.element = Element.THUNDER;
			break;
		case "LIGHT":
			this.element = Element.LIGHT;
			break;
		case "DARK":
			this.element = Element.DARK;
			break;
		default:
			throw new IllegalArgumentException(element
					+ " is an invalid element.");
		}
	}

	public String getName() {
		return name;
	}

	public boolean has() {
		return isHas;
	}

	public int getStars() {
		return stars;
	}

	public boolean isEvent() {
		return isEvent;
	}

	public String getElement() {
		switch (element) {
		case FIRE:
			return "FIRE";
		case WIND:
			return "WIND";
		case THUNDER:
			return "THUNDER";
		case LIGHT:
			return "LIGHT";
		case DARK:
			return "DARK";
		default:
			throw new RuntimeException("No valid element found.");
		}
	}

	public String getStory() {
		return story;
	}
}
