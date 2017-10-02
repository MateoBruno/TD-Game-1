import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevel;

public class level1 extends GameLevel
{
	@Override public void create()
	{
		GameObject background = new Background();
		GameObject background2 = new Background();
		background2.setPositionY(432);
		GameObject player = new Player();
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{

	}

	@Override public void uninitialize()
	{

	}
}
