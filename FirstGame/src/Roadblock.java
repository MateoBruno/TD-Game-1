import edu.digipen.gameobject.GameObject;

public class Roadblock extends GameObject
{
	public Roadblock()
	{
		super("Roadblock", 54, 28, "Roadblock.png");
	}
	@Override public void update (float dt)
	{
		setRectangleCollider(27, 14);
	}
}
