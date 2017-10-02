import edu.digipen.Game;

public class Main
{

    public static void main(String[] args){
        Game.initialize(288, 516, 60, new level1());
        while (Game.getQuit() == false)
        {
            Game.update();
        }
        Game.destroy();
    }
}
