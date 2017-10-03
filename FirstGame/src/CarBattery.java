import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

public class CarBattery extends GameObject
{
	public Vec2 direction;
	public CarBattery(Vec2 direction_, Vec2 location)
	{
		super("CarBattery", 16, 10, "Car battery.png");
		direction = new Vec2();
		direction.setX(direction_.getX());
		direction.setY(direction_.getY());
		setPosition(location);
	}
	@Override public void update(float dt)
	{
		setRectangleCollider(8, 5);
		setPositionY(getPositionY() - 2);

		if(isInViewport() == false)
		{
			kill();
		}
	}
}
