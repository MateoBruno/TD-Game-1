import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;

public class ECDrone extends GameObject
{
	float speed = 1.2f;
	private boolean bolean = false;

	public ECDrone()
	{
		super("ECDrone", 45, 51, "Drone.png");
		setRectangleCollider(22, 25);
	}
	@Override public void update (float dt)
	{
		GameObject Player = ObjectManager.getGameObjectByName("Player");
		if(Player != null)
		{
			Vec2 vector = new Vec2();
			vector.setX(Player.getPositionX() - getPositionX() + 45);
			vector.setY(Player.getPositionY() - getPositionY());
			vector.normalize();
			setPositionX(getPositionX() + vector.getX() * speed);
			setPositionY(getPositionY() + vector.getY() * speed);
			vector.scale(speed);
		}
		if(getPositionX() > 154 || getPositionX() < - 154)
		{
			kill();
			level1.d--;
			level1.Board3[level1.Index3] = false;
			bolean =true;
		}
	}
	@Override public void collisionReaction(GameObject collidedWidth)
	{
		if(collidedWidth.getName().equals ("Player"))
		{
		}
	}
}
