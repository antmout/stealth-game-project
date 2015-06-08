package fr.iutvalence.ardechois.stealthgameproject;

import java.io.File;

import fr.iutvalence.ardechois.stealthgameproject.exceptions.InvalidMapSizeException;
import fr.iutvalence.ardechois.stealthgameproject.exceptions.InvalidPositionException;
import fr.iutvalence.ardechois.stealthgameproject.model.Blocks;
import fr.iutvalence.ardechois.stealthgameproject.model.Map;
import fr.iutvalence.ardechois.stealthgameproject.model.Position;
import fr.iutvalence.ardechois.stealthgameproject.view.EditorWindow;

public class Editor
{
	private Map map;
	private EditorWindow editorWindow;

	public Editor()
	{
		this.map = new Map();
		this.editorWindow = new EditorWindow(map);
	}

	public void setBlock(Position position, Blocks block)
	{
		try
		{
			map.setBlock(position, block);
		} catch (InvalidPositionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveMap(File file)
	{
		map.saveMapInFile(file);
	}
}
