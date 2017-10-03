import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;

public class ECCar extends GameObject
{
	float speed = 1f;
	int damage = 0;

	public ECCar()
	{
		super("ECCar", 57, 51, "Drivey boi.png");
	}
	@Override public void update (float dt)
	{
		GameObject Player = ObjectManager.getGameObjectByName("Player");
		Vec2 vector = new Vec2();
		vector.setX(Player.getPositionX() - getPositionX());
		vector.setY(Player.getPositionY() - getPositionY() - 87);
		vector.normalize();
		setPositionX(getPositionX() + vector.getX() * speed);
		setPositionY(getPositionY() + vector.getY() * speed);
		vector.scale(speed);

		setRectangleCollider(28, 25);
	}
	@Override public void collisionReaction(GameObject collidedWidth)
	{


		if(collidedWidth.getName().equals("Tire"))
		{
			kill();
		}
		if(collidedWidth.getName().equals("Rake"))
		{
			damage++;
			if(damage >= 5)
			{
				kill();
			}
		}
		if(collidedWidth.getName().equals("CarBattery"))
		{
			damage += 2;
			if(damage <= 5)
			{
				kill();
			}
		}
	}
}
