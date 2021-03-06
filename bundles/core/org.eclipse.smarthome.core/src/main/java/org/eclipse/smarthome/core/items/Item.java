/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.items;

import java.util.List;
import java.util.Set;

import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;

/**
 * <p>This interface defines the core features of an openHAB item.</p>
 * <p>Item instances are used for all stateful services and are especially
 * important for the {@link ItemRegistry}.</p>
 * 
 * @author Kai Kreuzer - Initial contribution and API
 *
 */
public interface Item {

	/**
	 * returns the current state of the item
	 * 
	 * @return the current state
	 */
	public State getState();

	/**
	 * returns the current state of the item as a specific type
	 * 
	 * @return the current state in the requested type or 
	 * null, if state cannot be provided as the requested type 
	 */
	public State getStateAs(Class<? extends State> typeClass);

	/**
	 * returns the name of the item
	 * 
	 * @return the name of the item
	 */
	public String getName();
	
	/**
	 * returns the item type as defined by {@link ItemFactory}s
	 * 
	 * @return the item type
	 */
	public String getType();
	
	/**
	 * <p>This method provides a list of all data types that can be used to update the item state</p>
	 * <p>Imagine e.g. a dimmer device: It's status could be 0%, 10%, 50%, 100%, but also OFF or ON and
	 * maybe UNDEFINED. So the  accepted data types would be in this case {@link PercentType}, {@link OnOffType}
	 * and {@link UnDefType}</p>
	 * 
	 * @return a list of data types that can be used to update the item state
	 */
	public List<Class<? extends State>> getAcceptedDataTypes();
	
	
	/**
	 * <p>This method provides a list of all command types that can be used for this item</p>
	 * <p>Imagine e.g. a dimmer device: You could ask it to dim to 0%, 10%, 50%, 100%, but 
	 * also to turn OFF or ON. So the  accepted command types would be in this case {@link PercentType},
	 * {@link OnOffType}</p>
	 * 
	 * @return a list of all command types that can be used for this item
	 */
	public List<Class<? extends Command>> getAcceptedCommandTypes();

	/**
	 * Returns a list of the names of the groups this item belongs to.
	 * 
	 * @return list of item group names
	 */
	public List<String> getGroupNames();
	
	/**
	 * Returns a set of tags. If the item is not tagged, an empty set is returned. 
	 * 
	 * @return set of tags.
	 */
	public Set<String> getTags();
	
	/**
	 * Returns true if the item's tags contains the specific tag, otherwise false.
	 * 
	 * @param tag - a tag whose presence in the item's tags is to be tested.
	 * @return true if the item's tags contains the specific tag, otherwise false.
	 */
	public boolean hasTag(String tag);
	
	/**
	 * 
	 * @param tag - a tag that is to be added to item's tags.
	 */
	public void addTag(String tag);
	
	/**
	 * 
	 * @param tag - a tag that is to be removed from item's tags. 
	 */
	public void removeTag(String tag);
	
	/**
	 * Clears all tags of this item.
	 */
	public void removeAllTags();
}