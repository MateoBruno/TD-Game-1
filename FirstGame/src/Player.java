import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;

import java.awt.event.KeyEvent;

public class Player extends GameObject
{
	public Player()
	{
		super("Player", 66, 129, "Truck.png");
	}
	@Override public void update (float dt)
	{
		if(InputManager.isPressed(KeyEvent.VK_LEFT) || InputManager.isPressed(KeyEvent.VK_A))
		{
			setPositionX(getPositionX() - 1);
		}
		if(InputManager.isPressed(KeyEvent.VK_RIGHT) || InputManager.isPressed(KeyEvent.VK_D))
		{
			setPositionX(getPositionX() + 1);
		}
	}
}
