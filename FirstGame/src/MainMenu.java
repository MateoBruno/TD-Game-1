import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.SoundManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

public class MainMenu extends GameLevel
{
	private static boolean True = true;
	@Override public void create()
	{
		GameObject Menu = new Menu();
		SoundManager.addBackgroundSound("Music","Music.wav",true);
	}

	@Override public void initialize()
	{
		if(True)
		{
			SoundManager.playBackgroundSound("Music");
			True=false;
		}
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
