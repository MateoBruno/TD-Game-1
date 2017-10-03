import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;
import edu.digipen.math.PFRandom;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class level1 extends GameLevel
{
	public static int Index ;
	public static boolean Board[] = new boolean[10];
	static int a = 0;
	static int aa = 1;
	public static int Index1 ;
	public static boolean Board1[] = new boolean[10];
	static int b = 0;
	static int bb = 2;
	@Override public void create()
	{
		Arrays.fill(Board,false);
		Arrays.fill(Board1,false);
		GameObject background = new Background();
		GameObject background2 = new Background();
		background2.setPositionY(432);
		GameObject background3 = new Background();
		background3.setPositionY(864);
		GameObject player = new Player();
		GameObject ECCar = new ECCar();
		ECCar.setPositionY(-432);
		GameObject ECDrone = new ECDrone();
	}

	@Override public void initialize()
	{
		Graphics.setDrawCollisionData(true);
	}

	@Override public void update(float v)
	{
		Index = PFRandom.randomRange(0,3);
		if (!Board[Index]&& a<aa)
		{
			GameObject Gas = new Gas();
			ObjectManager.addGameObject(Gas);
			Gas.setPositionX(Index*100-100);
			Gas.setPositionY(PFRandom.randomRange(600,800));
			Board[Index] = true;
			a++;
		}
		Index1 = PFRandom.randomRange(0,4);
		if (!Board1[Index1]&& b<bb)
		{
			GameObject Roadblock = new Roadblock();
			ObjectManager.addGameObject(Roadblock);
			Roadblock.setPositionX(Index1*100-100);
			Roadblock.setPositionY(PFRandom.randomRange(400,600));
			Board1[Index1] = true;
			b++;
		}
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.destroy();
		}
	}

	@Override public void uninitialize()
	{

	}
}
