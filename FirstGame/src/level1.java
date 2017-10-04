import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.math.PFRandom;
import edu.digipen.text.FontTypes;
import edu.digipen.text.TextObject;

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
	public static int Index2 ;
	public static boolean Board2[] = new boolean[10];
	static int c = 0;
	static int cc = 2;
	public static int Index3 ;
	public static boolean Board3[] = new boolean[10];
	static int d = 0;
	static int dd = 2;
	TextObject text;
	TextObject text2;
	@Override public void create()
	{
		Arrays.fill(Board,false);
		Arrays.fill(Board1,false);
		Arrays.fill(Board2,false);
		Arrays.fill(Board3,false);
		GameObject background = new Background();
		GameObject background2 = new Background();
		background2.setPositionY(432);
		GameObject background3 = new Background();
		background3.setPositionY(864);
		GameObject player = new Player();
	}

	@Override public void initialize()
	{
		Arrays.fill(Board,false);
		Arrays.fill(Board1,false);
		Arrays.fill(Board2,false);
		Arrays.fill(Board3,false);
		aa = 1;
		bb = 1;
		cc = 2;
		dd = 2;
		a = 0;
		b = 0;
		c = 0;
		d = 0;
		Graphics.setDrawCollisionData(true);
		Player.health = 100;
		Player.distance = 0;
		text = new TextObject("text","distance: " +Player.distance, FontTypes.ARIAL_32);
		text.destroy();
		text2 = new TextObject("text2","health: " + Player.health, FontTypes.ARIAL_32);
		text2.destroy();
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
		Index1 = PFRandom.randomRange(0,3);
		if (!Board1[Index1]&& b<bb)
		{
			GameObject Roadblock = new Roadblock();
			ObjectManager.addGameObject(Roadblock);
			Roadblock.setPositionX(Index1*100-100);
			Roadblock.setPositionY(PFRandom.randomRange(400,600));
			Board1[Index1] = true;
			b++;
		}
		Index2 = PFRandom.randomRange(0,1);
		if (!Board2[Index2]&& c<cc)
		{
			GameObject ECCar = new ECCar();
			ObjectManager.addGameObject(ECCar);
			ECCar.setPositionX(Index2*100-100);
			ECCar.setPositionY(PFRandom.randomRange(400,600) * -1);
			Board2[Index2] = true;
			c++;
		}
		Index3 = PFRandom.randomRange(0,1);
		if (!Board3[Index3]&& c<cc)
		{
			GameObject ECDrone = new ECDrone();
			ObjectManager.addGameObject(ECDrone);
			ECDrone.setPositionX(Index3*100-100);
			ECDrone.setPositionY(PFRandom.randomRange(400,600) * -1);
			Board3[Index3] = true;
			d++;
		}
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.destroy();
		}
		if(Player.health < 1)
		{
			uninitialize();
			GameLevelManager.goToLevel(new Lose());
		}
		text.setText("distance: " + Player.distance);
		text.setScale(.8f, .8f);
		text.setZOrder(50);
		text.setPosition(-140,250);
		text.destroy();
		text2.setText("health: " + Player.health);
		text2.setScale(.8f, .8f);
		text2.setZOrder(50);
		text2.setPosition(10, 250);
		text2.destroy();
	}

	@Override public void uninitialize()
	{

	}
}
