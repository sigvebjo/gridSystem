package no.ntnu.sigvebjo.gridsystem;

import java.util.HashMap;

/**
 * A grid.
 * Consists of a width and a height,
 * and acts as a container for gridItems.
 */
public class Grid {
    private int gridWidth;
    private int gridHeight;

    private HashMap<int[], GridItem> gridItems;

    public Grid(int width, int height) {
        this.gridWidth = width;
        this.gridWidth = height;

        this.gridItems = new HashMap<int[], GridItem>();
    }

    /**
     * Generates a positionkey, and validates position parameters.
     *
     * @param positionX the x-component (horizontal) of the position
     * @param positionY the y-component (vertical) of the position
     * @return a position key. On an invalid input, position key is [0,0]
     */
    private int[] generatePositionKey(int positionX, int positionY) {
        if (positionX > this.gridWidth || positionY > gridHeight) {
            positionX = 0;
            positionY = 0;
        }

        int[] positionKey = {positionX, positionY};

        return positionKey;
    }

    /**
     * Gets a gridItem from this grid given two coordinates.
     *
     * @param positionX the horizontal (x) position to search at
     * @param positionY the vertical (y) position to search at
     * @return a gridItem found at the tile, or null if none was found
     */
    public GridItem getGridTileFromPosition(int positionX, int positionY) {
        int[] positionKey = generatePositionKey(positionX, positionY);

        return gridItems.get(positionKey);
    }

    /**
     * Attempts to place a gridItem at the given position. gridItem can be null.
     *
     * @param positionX the horizontal (x) position at which to place the item
     * @param positionY the vertical (y) position at which to place the item
     * @param item the item to be placed, can be null to remove an item
     * @return success boolean
     */
    public boolean setGridTile(int positionX, int positionY, GridItem item) {
        boolean success = false;

        int[] positionKey = generatePositionKey(positionX, positionY);

        gridItems.put(positionKey, item);
        
        if (getGridTileFromPosition(positionX, positionY) == item) {success = true;}

        return success;
    }
}
