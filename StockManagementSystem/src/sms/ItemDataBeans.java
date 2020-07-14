package sms;

import java.io.Serializable;

public class ItemDataBeans implements Serializable {
	private int item_id;
	private String name;
	private int stock;

	public ItemDataBeans(){
        this.setItem_id(0);
        this.setName("");
        this.setStock(0);
    }

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
