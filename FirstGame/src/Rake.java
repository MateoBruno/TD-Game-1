import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

public class Rake extends GameObject
{
	public Vec2 direction;
	public Rake(Vec2 direction_, Vec2 location)
	{
		super("Rake", 11, 16, "Rake.png");
		direction = new Vec2();
		direction.setX(direction_.getX());
		direction.setY(direction_.getY());
		setPosition(location);
	}
	@Override public void update(float dt)
	{
		setRectangleCollider(5, 8);
		setPositionY(getPositionY() - 2);

		if(isInViewport() == false)
		{
			kill();
		}
	}
	@Override public void collisionReaction(GameObject collidedWidth)
	{
		if(collidedWidth.getName().equals ("ECCar"))
		{
			kill();
		}
	}
}
