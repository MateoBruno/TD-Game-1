import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

public class MainMenu extends GameLevel
{
	@Override public void create()
	{
		GameObject Menu = new Menu();
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		if(InputManager.isPressed(KeyEvent.VK_1))
		{
			GameLevelManager.goToLevel(new level1());
		}
		if(InputManager.isPressed(KeyEvent.VK_2))
		{
			GameLevelManager.goToLevel(new HowTo());
		}
		if(InputManager.isPressed(KeyEvent.VK_3))
		{
			GameLevelManager.goToLevel(new HistoryLevel());
		}
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.destroy();
		}
	}

	@Override public void uninitialize()
	{

	}
}
