package com.absi.jsftable;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ejb.EJB;

import com.absi.jsftable.Glass;
import com.absi.jsftable.StoreBean;


@Path("/store")
public class StoreService
{
	@EJB
	private StoreBean store;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allglass")
	public List<Glass> getAllGlass()
	{
		return store.getGlassStock();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rallglass")
	public Response rgetAllGlass()
	{
		return Response.ok(store.getGlassStock()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addglass")
	public void addGlass(Glass newGlass)
	{
		store.createGlass(newGlass);
	}
}