package com.absi.jsftable;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.event.ValueChangeEvent;
import javax.faces.context.FacesContext;
import javax.el.ELContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ejb.EJB;

import com.absi.jsftable.Glass;
import com.absi.jsftable.StoreBean;

@Named("appbean")
@SessionScoped
public class AppBean implements Serializable
{
	@EJB
	private StoreBean store;

	private List<Glass> glassStock;

	public List<Glass> getGlassStock() { return this.glassStock; }

	public AppBean() {}

	@PostConstruct
	public void init()
	{
		this.glassStock = store.getGlassStock();
	}

	public String copyLastItem()
	{
		this.glassStock = store.duplicateLastItem();
		return null;
	}

	/*
	public void glassChanged(ValueChangeEvent event) throws AbortProcessingException
	{
		this.ajaxVal = "changed";
		for(Glass g: this.glassStock)
			g.setStock(3);
	}

	public void glassChanged(AjaxBehaviorEvent event) throws AbortProcessingException
	{
		this.ajaxVal = "changed";
		for(Glass g: this.glassStock)
			g.setStock(3);
	}
	
	public void glassChanged(ValueChangeEvent event) throws AbortProcessingException
	{

		ELContext elc = event.getFacesContext().getELContext();
		event.getComponent().getValueExpression("value").setValue(elc, event.getNewValue());
	}

	public void glassChanged(AjaxBehaviorEvent event) throws AbortProcessingException
	{

		ELContext elc = event.getFacesContext().getELContext();
		event.getComponent().getValueExpression("value").setValue(elc, event.getNewValue());
	}
	*/
}