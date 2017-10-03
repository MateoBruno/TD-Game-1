import edu.digipen.gameobject.GameObject;

public class Roadblock extends GameObject
{
	private boolean bolean = false;
	public Roadblock()
	{
		super("Roadblock", 54, 28, "Roadblock.png");
		setRectangleCollider(27,14);
	}
	@Override public void update(float dt)
	{
		setPositionY(getPositionY()-2);
		if(getPositionY()<=-260&&!bolean)
		{
			level1.b--;
			level1.Board1[level1.Index1] = false;
			bolean =true;
			kill();
		}
	}

	@Override public void collisionReaction(GameObject collidedWith)
	{
		if(collidedWith.getName().equals("Player"))
		{
			kill();
			if(!bolean)
			{
				level1.b--;
				level1.Board1[level1.Index1] = false;
				bolean =true;
			}
		}

	}
}
