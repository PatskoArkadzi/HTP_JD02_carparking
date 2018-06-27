package by.htp.carparking.domain.springDataDomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = -3534865590754373783L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "model")
	private String model;
	@Column(name = "brand")
	private String brand;
	@Column(name = "leased")
	private boolean leased;
	@Column(name = "pricePerDay")
	private BigDecimal pricePerDay;
	@Fetch(FetchMode.JOIN)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private Set<Order> orders;

	public Car(int id, String model, String brand, boolean leased, BigDecimal pricePerDay, Set<Order> orders) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.leased = leased;
		this.pricePerDay = pricePerDay;
		this.orders = orders;
	}

	public Car() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + (leased ? 1231 : 1237);
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((pricePerDay == null) ? 0 : pricePerDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id != other.id)
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
		return "Car [id=" + id + ", model=" + model + ", brand=" + brand + ", leased=" + leased + ", pricePerDay="
				+ pricePerDay + "]";
	}

}
