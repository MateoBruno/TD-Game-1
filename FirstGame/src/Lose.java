import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

public class Lose extends GameLevel
{
	@Override public void create()
	{
		GameObject EndLose = new EndLose();
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
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.destroy();
		}
	}

	@Override public void uninitialize()
	{

	}
}
