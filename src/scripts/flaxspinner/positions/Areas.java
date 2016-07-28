package scripts.flaxspinner.positions;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public enum Areas {

	BANK(new RSArea(new RSTile(2721, 3493, 0), new RSTile(2729, 3490, 0))),
	
	BUILDING_GROUND_FLOOR(new RSArea(new RSTile(2709, 3469, 0), new RSTile(2719, 3475, 0))),
	
	BUILDING_FIRST_FLOOR(new RSArea(new RSTile(2710, 3473, 1), new RSTile(2716, 3470, 1))),
	
	LUMBY_THIRD_FLOOR(new RSArea(new RSTile(3205, 3229, 2), new RSTile(3216, 3208, 2))),
	
	LUMBY_SECOND_FLOOR(new RSArea(new RSTile(3205, 3229, 1), new RSTile(3216, 3208, 1))),
	
	LUMBY_FIRST_FLOOR(new RSArea(new RSTile(3205, 3229, 0), new RSTile(3216, 3208, 0))),;
	
	private RSArea area;

	Areas(RSArea area) {
		this.area = area;
	}
	
	public RSArea getArea(){
		return this.area;
	}
	
}
