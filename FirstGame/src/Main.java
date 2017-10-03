import edu.digipen.Game;

public class Main
{

    public static void main(String[] args){
        Game.initialize(305, 536, 60, new MainMenu());
        while (Game.getQuit() == false)
        {
            Game.update();
        }
        Game.destroy();

    }
}
