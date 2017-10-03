import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.PFRandom;
import edu.digipen.math.Vec2;

import java.awt.event.KeyEvent;

public class Player extends GameObject
{
	public Vec2 direction = new Vec2(1.0f, 0.0f);
	float timer = 0.0f;

	public Player()
	{
		super("Player", 66, 129, "Truck.png");
	}
	private void drop()
	{
		int i = PFRandom.randomRange(1, 100);
		if(i < 49)
		{
			ObjectManager.addGameObject(new Rake(direction, getPosition()));
		}
		if(i > 49 && i < 90)
		{
			ObjectManager.addGameObject(new CarBattery(direction, getPosition()));
		}
		if(i > 90)
		{
			ObjectManager.addGameObject(new Tire(direction, getPosition()));
		}
	}
	@Override public void update (float dt)
	{
		timer += dt;
		if(InputManager.isPressed(KeyEvent.VK_LEFT) || InputManager.isPressed(KeyEvent.VK_A))
		{
			setPositionX(getPositionX() - 2);
		}
		if(InputManager.isPressed(KeyEvent.VK_RIGHT) || InputManager.isPressed(KeyEvent.VK_D))
		{
			setPositionX(getPositionX() + 2);
		}
		if(InputManager.isTriggered(KeyEvent.VK_SPACE) && timer > 0.5)
		{
			timer = 0.0f;
			drop();
		}

		if(getPositionX() > 111)
		{
			setPositionX(getPositionX() - 2);
		}
		if(getPositionX() < -111)
		{
			setPositionX(getPositionX() + 2);
		}

		setRectangleCollider(31, 64);
	}
}
