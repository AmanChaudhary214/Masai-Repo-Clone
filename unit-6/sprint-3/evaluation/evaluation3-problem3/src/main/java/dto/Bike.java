package dto;

public class Bike {

	private String bikeNo;
	private String bikeColor;
	private String modelName;
	
	public Bike() {
		super();
	}

	public Bike(String bikeNo, String bikeColor, String modelName) {
		super();
		this.bikeNo = bikeNo;
		this.bikeColor = bikeColor;
		this.modelName = modelName;
	}

	public String getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(String bikeNo) {
		this.bikeNo = bikeNo;
	}

	public String getBikeColor() {
		return bikeColor;
	}

	public void setBikeColor(String bikeColor) {
		this.bikeColor = bikeColor;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return "Bike [bikeNo=" + bikeNo + ", bikeColor=" + bikeColor + ", modelName=" + modelName + "]";
	}
	
}
