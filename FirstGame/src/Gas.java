import edu.digipen.gameobject.GameObject;

public class Gas extends GameObject
{
	private boolean bolean = false;
	public Gas()
	{
		super("Gas", 31, 19, "Jerry can.png");
		setRectangleCollider(15, 9);
	}
	@Override public void update(float dt)
	{
		setPositionY(getPositionY()-2);
		if(getPositionY()<=-260&&!bolean)
		{
			level1.a--;
			level1.Board[level1.Index] = false;
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
				level1.a--;
				level1.Board[level1.Index] = false;
				bolean =true;
			}
		}

	}
}
