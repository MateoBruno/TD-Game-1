import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

public class Tire extends GameObject
{
	public Vec2 direction;
	public Tire(Vec2 direction_, Vec2 location)
	{
		super("Tire", 22, 22, "Wheel.png");
		direction = new Vec2();
		direction.setX(direction_.getX());
		direction.setY(direction_.getY());
		setPosition(location);
	}
	@Override public void update(float dt)
	{
		setCircleCollider(11);
		setPositionY(getPositionY() - 2);

		if(isInViewport() == false)
		{
			kill();
		}
	}
}
