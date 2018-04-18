package by.htp.carparking.domain;

import java.sql.Date;

public class Order extends Entity {
	private static final long serialVersionUID = -5731960048387459760L;
	int user_id;
	int car_id;
	Date dateStart;
	Date dateEnd;

	public Order() {
	}

	public Order(int id, int user_id, int car_id, Date dateStart, Date dateEnd) {
		super(id);
		this.user_id = user_id;
		this.car_id = car_id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + car_id;
		result = prime * result + user_id;
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
		Order other = (Order) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (car_id != other.car_id)
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", car_id=" + car_id + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd
				+ "]";
	}
	

}
