import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;

public class ECCar extends GameObject
{
	float speed = 1f;
	int damage = 0;
	private boolean bolean = false;

	public ECCar()
	{
		super("ECCar", 57, 51, "Drivey boi.png");
		setRectangleCollider(28, 25);
	}
	@Override public void update (float dt)
	{
		GameObject Player = ObjectManager.getGameObjectByName("Player");
		if(Player != null)
		{
			Vec2 vector = new Vec2();
			vector.setX(Player.getPositionX() - getPositionX());
			vector.setY(Player.getPositionY() - getPositionY() - 75);
			vector.normalize();
			setPositionX(getPositionX() + vector.getX() * speed);
			setPositionY(getPositionY() + vector.getY() * speed);
			vector.scale(speed);
		}



		//setPositionY(getPositionY()-2);
		//if(getPositionY()<=-260&&!bolean)
		//{
		//	level1.c--;
		//	level1.Board2[level1.Index2] = false;
		//	bolean =true;
		//	kill();
		//}
	}
	@Override public void collisionReaction(GameObject collidedWidth)
	{
		//if(collidedWidth.getName().equals("Tire") || collidedWidth.getName().equals("Rake") || collidedWidth.getName().equals("CarBattery"))
		//{
			//kill();
			if(damage >=5)
			{
				level1.c--;
				level1.Board2[level1.Index2] = false;
				bolean =true;
			}
		//}

		if(collidedWidth.getName().equals("Tire"))
		{
			kill();
			level1.c--;
			level1.Board2[level1.Index2] = false;
			bolean =true;
		}
		if(collidedWidth.getName().equals("Rake"))
		{
			damage++;
			if(damage >= 5)
			{
				kill();
				level1.c--;
				level1.Board2[level1.Index2] = false;
				bolean =true;
			}
		}
		if(collidedWidth.getName().equals("CarBattery"))
		{
			damage += 2;
			if(damage >= 5)
			{
				kill();
				level1.c--;
				level1.Board2[level1.Index2] = false;
				bolean =true;
			}
		}
	}
}
