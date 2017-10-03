import edu.digipen.gameobject.GameObject;

public class Background extends GameObject
{
	public Background()
	{
		super("Background", 288, 516, "Background.png");
		setZOrder(-1);
	}
	@Override public void update (float dt)
	{
		float scrollSpeed = 4f;
		setPositionY(getPositionY() - scrollSpeed);
		if (getPositionY() < -432)
		{
			setPositionY(864);
		}
	}
}
