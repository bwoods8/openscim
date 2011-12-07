/*
 * openscim restful scim server
 * http://code.google.com/p/openscim/
 * Copyright (C) 2011 Matthew Crooke <matthewcrooke@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package openscim.restful.server.resources.group;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/Groups")
public abstract class GroupsResource
{
	/**
	 * Retrieve the Groups
	 * 
	 * @param uriInfo
	 * @param attributes
	 * @param filter
	 * @param sortBy
	 * @param sortOrder
	 * @param startIndex
	 * @param count
	 * @return
	 */
	@Path(".json")
	@GET		
	@Produces(MediaType.APPLICATION_JSON)
	public final Response listGroupsAsJSON(@Context UriInfo uriInfo, @QueryParam("attributes") String attributes, 
			@QueryParam("filter") String filter, 
			@QueryParam("sortBy") String sortBy, 
			@QueryParam("sortOrder") String sortOrder, 
			@DefaultValue("-1") @QueryParam("startIndex") int startIndex, 
			@DefaultValue("-1") @QueryParam("count") int count)
	{
		return listGroups(uriInfo, attributes, filter, sortBy, sortOrder, startIndex, count);
	}
	
	/**
	 * Retrieve the Groups
	 * 
	 * @param uriInfo
	 * @param attributes
	 * @param filter
	 * @param sortBy
	 * @param sortOrder
	 * @param startIndex
	 * @param count
	 * @return
	 */
	@Path(".xml")
	@GET		
	@Produces(MediaType.APPLICATION_XML)
	public final Response listGroupsAsXML(@Context UriInfo uriInfo, @QueryParam("attributes") String attributes, 
			@QueryParam("filter") String filter, 
			@QueryParam("sortBy") String sortBy, 
			@QueryParam("sortOrder") String sortOrder, 
			@DefaultValue("-1") @QueryParam("startIndex") int startIndex, 
			@DefaultValue("-1") @QueryParam("count") int count)
	{
		return listGroups(uriInfo, attributes, filter, sortBy, sortOrder, startIndex, count);
	}
	
	/**
	 * Retrieve the Groups
	 * 
	 * @param uriInfo
	 * @param attributes
	 * @param filter
	 * @param sortBy
	 * @param sortOrder
	 * @param startIndex
	 * @param count
	 * @return
	 */
	@GET		
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public abstract Response listGroups(@Context UriInfo uriInfo, @QueryParam("attributes") String attributes, 
			@QueryParam("filter") String filter, 
			@QueryParam("sortBy") String sortBy, 
			@QueryParam("sortOrder") String sortOrder, 
			@DefaultValue("-1") @QueryParam("startIndex") int startIndex, 
			@DefaultValue("-1") @QueryParam("count") int count);
}
