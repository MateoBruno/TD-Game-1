import edu.digipen.gameobject.GameObject;

public class Gas extends GameObject
{
	public Gas()
	{
		super("Gas", 31, 19, "Jerry can.png");
	}
	@Override public void update(float dt)
	{
		setRectangleCollider(15, 9);
	}
}
