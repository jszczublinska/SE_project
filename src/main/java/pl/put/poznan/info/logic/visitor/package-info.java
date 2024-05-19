/**
 * Provides interfaces and classes for implementing the visitor pattern to take action based on locations.
 * <p>
 * This package contains the {@link pl.put.poznan.info.logic.visitor.LocationVisitorInt} interface,
 * which defines the contract for a visitor that takes action based on component locations. Implementations
 * of this interface can be used to visit different types of locations in a composite structure and perform
 * operation that is retrieving information about the building.
 * </p>
 * <p>
 * Additionally, this package includes several implementations of the {@link pl.put.poznan.info.logic.visitor.LocationVisitorInt}
 * interface:
 * <ul>
 *     <li>{@link pl.put.poznan.info.logic.visitor.VisitorArea}: A visitor implementation for calculating area.</li>
 *     <li>{@link pl.put.poznan.info.logic.visitor.VisitorVolume}: A visitor implementation for calculating volume.</li>
 *     <li>{@link pl.put.poznan.info.logic.visitor.VisitorLighting}: A visitor implementation for calculating lighting.</li>
 * </ul>
 * </p>
 */
package pl.put.poznan.info.logic.visitor;
