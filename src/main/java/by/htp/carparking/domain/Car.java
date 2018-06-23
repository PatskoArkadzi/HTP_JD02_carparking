package by.htp.carparking.domain;

import java.math.BigDecimal;

public class Car extends Entity {

	private static final long serialVersionUID = -3534865590754373783L;
	private String model;
	private String brand;
	private boolean leased;
	private BigDecimal pricePerDay;

	public Car(int id, String model, String brand, boolean leased, BigDecimal pricePerDay) {
		super(id);
		this.model = model;
		this.brand = brand;
		this.leased = leased;
		this.pricePerDay = pricePerDay;
	}

	public Car() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isLeased() {
		return leased;
	}

	public void setLeased(boolean leased) {
		this.leased = leased;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + (leased ? 1231 : 1237);
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((pricePerDay == null) ? 0 : pricePerDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (leased != other.leased)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (pricePerDay == null) {
			if (other.pricePerDay != null)
				return false;
		} else if (!pricePerDay.equals(other.pricePerDay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", brand=" + brand + ", leased=" + leased + ", pricePerDay=" + pricePerDay + "]";
	}

}
