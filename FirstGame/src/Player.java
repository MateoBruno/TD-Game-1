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
	float timer1 = 0.0f;
	public static int health = 100;
	public static double distance = 1;

	public Player()
	{
		super("Player", 55, 107, "Truck.png");
		setPositionY(-100);
	}
	private void drop()
	{
		int i = PFRandom.randomRange(1, 100);
		if(i < 65)
		{
			ObjectManager.addGameObject(new Rake(direction, getPosition()));
		}
		if(i > 65 && i < 95)
		{
			ObjectManager.addGameObject(new CarBattery(direction, getPosition()));
		}
		if(i > 95)
		{
			ObjectManager.addGameObject(new Tire(direction, getPosition()));
		}
	}
	@Override public void update (float dt)
	{
		timer += dt;
		timer1 += dt;
		distance += .5;
		if(InputManager.isPressed(KeyEvent.VK_LEFT) || InputManager.isPressed(KeyEvent.VK_A))
		{
			setPositionX(getPositionX() - 2);
		}
		if(InputManager.isPressed(KeyEvent.VK_RIGHT) || InputManager.isPressed(KeyEvent.VK_D))
		{
			setPositionX(getPositionX() + 2);
		}
		if(InputManager.isTriggered(KeyEvent.VK_SPACE) && timer1 > 0.5)
		{
			timer1 = 0.0f;
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
		System.out.println(distance);
		setRectangleCollider(27, 53);
	}
	@Override public void collisionReaction(GameObject collidedWidth)
	{
		if(collidedWidth.getName().equals("ECCar"))
		{
			if(timer > 0.5)
			{
				health -= 5;
				timer = 0.0f;
			}
		}
		if(collidedWidth.getName().equals("ECDrone"))
		{
			if(timer > 0.5)
			{
				health -= 5;
				timer = 0.0f;
			}
		}
		if(collidedWidth.getName().equals("Roadblock"))
		{
			health = 0;
		}
		if(collidedWidth.getName().equals("Gas"))
		{
			if(health < 86)
			{
				health += 15;
			}
			if(health > 86)
			{
				health = 100;
			}
		}
	}
}
