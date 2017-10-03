import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;

import java.awt.event.KeyEvent;

public class level1 extends GameLevel
{
	@Override public void create()
	{
		GameObject background = new Background();
		GameObject background2 = new Background();
		background2.setPositionY(432);
		GameObject background3 = new Background();
		background3.setPositionY(864);
		GameObject player = new Player();
		GameObject ECCar = new ECCar();
		ECCar.setPositionY(-432);
		GameObject ECDrone = new ECDrone();
	}

	@Override public void initialize()
	{
		Graphics.setDrawCollisionData(true);
	}

	@Override public void update(float v)
	{
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.destroy();
		}
	}

	@Override public void uninitialize()
	{

	}
}
