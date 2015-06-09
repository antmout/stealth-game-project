package fr.iutvalence.ardechois.stealthgameproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import fr.iutvalence.ardechois.stealthgameproject.exceptions.InvalidPositionException;
import fr.iutvalence.ardechois.stealthgameproject.model.Blocks;
import fr.iutvalence.ardechois.stealthgameproject.model.Level;
import fr.iutvalence.ardechois.stealthgameproject.model.Position;
import fr.iutvalence.ardechois.stealthgameproject.view.EditorWindow;

/**
 * Allow to edit a map.
 * 
 * @author antoine
 * @version 0.1.0
 */
public class Editor implements MouseListener
{
	/** Default filename of map : {@value #DEFAULT_MAP_NAME}. */
	public static final String DEFAULT_MAP_NAME = "tempMap.txt";

	/**
	 * Level to edit.
	 * 
	 * @see Level
	 */
	private Level level;
	
	/**
	 * The Editor window.
	 * 
	 * @see EditorWindow
	 */
	private EditorWindow editorWindow;

	// Javadoc ;)
	private File file;

	/**
	 * Default constructor.
	 */
	public Editor()
	{
		this.file = new File(DEFAULT_MAP_NAME);
		this.level = new Level(this.file);
		this.editorWindow = new EditorWindow(level, level.getCurrentMap(), null, this);
	}

	// TODO Javadoc ;)
	public Editor(String filename)
	{
		this(new File(filename));
	}

	// TODO Javadoc ;)
	public Editor(File file)
	{
		this.file = file;
		this.level = new Level(this.file);
		this.editorWindow = new EditorWindow(level, level.getCurrentMap(), null, this);
	}

	// TODO Javadoc ;)
	public void setBlock(Position position, Blocks block)
	{
		try
		{
			level.getCurrentMap().setBlock(position, block);
		}
		catch (InvalidPositionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Save the edited map in a target file.
	 * 
	 * @param filename
	 */
	public void saveMap(String filename)
	{
		saveMap(new File(filename));
	}

	/**
	 * Save the edited map in a target file.
	 * 
	 * @param file
	 *            The target file in which the map will be saved.
	 */
	public void saveMap(File file)
	{
		level.getCurrentMap().saveMapInFile(file, level.getCurrentItem().getPosition());
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		Position mousePositionBlock = new Position(e.getX() / EditorWindow.PREFERRED_BLOCK_SIZE, e.getY()
				/ EditorWindow.PREFERRED_BLOCK_SIZE);
		switch (e.getButton())
		{
			case MouseEvent.BUTTON1 :
				if(!e.isAltDown() && !e.isControlDown())
				{
					try
					{
						level.getCurrentMap().setBlock(mousePositionBlock, level.getCurrentMap().getBlock(mousePositionBlock).getNext());
					}
					catch (InvalidPositionException e1)
					{
						System.out.println("Mouse button pressed out of map.");
					}
				}
				else if(e.isAltDown() && !e.isControlDown())
				{
					level.getCurrentMap().setSpawnPosition(mousePositionBlock);
				}
				else if(!e.isAltDown() && e.isControlDown())
				{
					level.getCurrentItem().setPosition(mousePositionBlock);
				}
				break;

			case MouseEvent.BUTTON3 :
				saveMap(file);
				System.out.println("Map saved in " + file.getName());
				break;

			case MouseEvent.BUTTON2 :
				level.getCurrentMap().reset();
				break;
		}

		editorWindow.invalidate();
		editorWindow.repaint();
		editorWindow.validate();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}
}
