package com.absi.jsftable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Glass
{
	private String name = "Glass";
	private int thickness = 4;
	private long width = 6000;
	private long height = 3210;
	private float price = 20.0f;
	private long stock = 0;

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setThickness(int thickness) { this.thickness = thickness; }
	public int getThickness() { return this.thickness; }

	public void setWidth(long width) { this.width = width; }
	public long getWidth() { return this.width; }

	public void setHeight(long height) { this.height = height; }
	public long getHeight() { return this.height; }

	public void setPrice(float price) { this.price = price; }
	public float getPrice() { return this.price; }

	public void setStock(long stock) { this.stock = stock; }
	public long getStock() { return this.stock; }


	public Glass() {}

	public Glass(String name, int thickness, float price)
	{
		this.name = name;
		this.thickness = thickness;
		this.price = price;
	}

	public Glass(String name, int thickness, long width, long height, float price, long stock)
	{
		this.name = name;
		this.thickness = thickness;
		this.width = width;
		this.height = height;
		this.price = price;
		this.stock = stock;
	}
}