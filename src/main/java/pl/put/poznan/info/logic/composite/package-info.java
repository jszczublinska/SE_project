/**
 * Provides interfaces and classes for managing component locations within a building's composite structure.
 * This package contains the {@link pl.put.poznan.info.logic.composite.ComponentLocation} interface, which
 * defines the methods for retrieving details about a location, calculating area, volume, heating, and lighting,
 * managing sub-locations, and accepting a visitor. Implementations of this interface represent different types
 * of locations within a building, such as buildings, floors, and rooms.
 * <br>
 * Additionally, this package includes several implementations of the {@link pl.put.poznan.info.logic.composite.ComponentLocation}
 * interface:
 * <ul>
 *     <li>{@link pl.put.poznan.info.logic.composite.CompositeBuilding}: Represents a building as a composite location,
 *     containing floors as sub-locations.</li>
 *     <li>{@link pl.put.poznan.info.logic.composite.CompositeFloor}: Represents a floor as a composite location,
 *     containing rooms as sub-locations.</li>
 *     <li>{@link pl.put.poznan.info.logic.composite.Room}: Represents a room as a primary location within a building.</li>
 * </ul>
 */
package pl.put.poznan.info.logic.composite;
