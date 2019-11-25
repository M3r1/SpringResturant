package Entities;

import java.util.ArrayList;

public class Order {
	
	private int id;
	private int tableNum;
	private ArrayList<Dish> tableDishes = new ArrayList<>();

	public Order() {
	}
	
	public Order(int id) {
	}
	
	public int getId() {
		return id;
	}


	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public ArrayList<Dish> getTableDishes() {
		return tableDishes;
	}

	public void setTableDishes(ArrayList<Dish> tableDishes) {
		this.tableDishes = tableDishes;
	}
	
	public void addTableDish(Dish dish) {
		this.tableDishes.add(dish);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", tableNum=" + tableNum + ", tableDishes=" + tableDishes + "]";
	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tableDishes == null) ? 0 : tableDishes.hashCode());
		result = prime * result + tableNum;
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (tableDishes == null) {
			if (other.tableDishes != null)
				return false;
		} else if (!tableDishes.equals(other.tableDishes))
			return false;
		if (tableNum != other.tableNum)
			return false;
		return true;
	}
	
	
	

}
