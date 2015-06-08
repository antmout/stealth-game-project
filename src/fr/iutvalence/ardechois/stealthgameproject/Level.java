package fr.iutvalence.ardechois.stealthgameproject;

import java.util.ArrayList;

import fr.iutvalence.ardechois.stealthgameproject.exceptions.InvalidMapSizeException;

/**
 * Level of the game.
 * 
 * @author antoine
 * @version 0.1.0
 *
 */
public class Level
{

    // Constants

    // Attributes

    /** Current Map of the level. */
    private Map currentMap;

    /** List of the current enemies. */
    private ArrayList<Enemy> enemyList;

    /** Current item of the level. */
    private Item currentItem;

    // Constructors
    
    /**
     * Default constructor of the level.
     */
    public Level()
    {
        try
		{
			currentMap = new Map();
		} catch (InvalidMapSizeException e)
		{
			// never happen
		}
        currentItem = new Item(new Position(0, 0));
        enemyList = new ArrayList<Enemy>();

    }
    // Methods
    /**
     * Getter of the current map.
     * 
     * @return currentMap
     */
    public Map getCurrentMap()
    {
        return currentMap;
    }

    /**
     * Getter of the current item.
     * 
     * @return currentItem
     */
    public Item getCurrentItem()
    {
        return currentItem;
    }

    /**
     * Setter of the current item.
     * 
     * @param currentItem
     */
    public void setCurrentItem(Item currentItem)
    {
        this.currentItem = currentItem;
    }
}
