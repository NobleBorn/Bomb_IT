package Models;

/**
 * Classes that implements Destroyable must implement terminate method which removes the object of the class from map
 */
public interface Destroyable {
    /**
     * Method to remove the object of the class from map
     */
    void terminate();
}
