package com.absi.jsftable;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;

import com.absi.jsftable.Glass;

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Startup
@Singleton
public class StoreBean
{
	private List<Glass> glassStock;


	@PostConstruct
	public void init()
	{
		this.glassStock = new ArrayList<>();
		this.glassStock.add(new Glass("Planibel Grey", 4, 17.5f));
		this.glassStock.add(new Glass("Stopsol Clasic Green", 6, 22.5f));
		this.glassStock.add(new Glass("Planibel Priva Bluedfgdgdg dgdfgdfgdfg dfgdfgdgdfg dfgdfgdfgdfg", 6, 24.5f));
	}

	public StoreBean() {}

	@Lock(LockType.READ)
	public List<Glass> getGlassStock() { return this.glassStock; }

	@Lock(LockType.WRITE)
	public List<Glass> duplicateLastItem()
	{
		Glass lastGlass = glassStock.get(glassStock.size() - 1);
		Glass newGlass = new Glass(lastGlass.getName(), lastGlass.getThickness(), lastGlass.getPrice());
		this.glassStock.add(newGlass);

		return this.glassStock;
	}

}