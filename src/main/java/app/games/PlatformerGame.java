package app.games;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.commonobjects.Potion;
import app.games.platformerobjects.PlatformerLevel;
import app.games.platformerobjects.PlatformerWall;
import app.games.platformerobjects.Spike;
import app.games.topdownobjects.Enemy;

public class PlatformerGame extends Game {
    @Override
    public void init() {

        this.addLevel(levelOne());
        this.addLevel(levelTwo());
        this.addLevel(extraLevelDX());
        this.addLevel(levelFour());
        this.addLevel(EndingLevel());
        this.loadLevel(this.getLevelList().getValue());

    }

    public Level levelOne(){

        Level level = new PlatformerLevel(this, 10, 10, "platformer_1");

        level.getStaticObjects().add(new PlatformerWall(1,7));
        level.getStaticObjects().add(new PlatformerWall(2,7));
        level.getStaticObjects().add(new PlatformerWall(3,7));

        level.getStaticObjects().add(new Goal(1, 6, this));

        level.getPlayerStartLocation().setX(5.0);
        level.getPlayerStartLocation().setY(7.0);


        return level;
    }

    public Level levelTwo() {
        Level level = new PlatformerLevel(this, 32, 15, "pl_level2");
        level.getStaticObjects().add(new Goal(19, 2, this));
        level.getPlayerStartLocation().setX(1.0);
        level.getPlayerStartLocation().setY(9.0);

        level.getStaticObjects().add(new PlatformerWall(1, 10));
        level.getStaticObjects().add(new PlatformerWall(2, 10));
        level.getStaticObjects().add(new PlatformerWall(3, 10));
        level.getStaticObjects().add(new PlatformerWall(4, 10));
        level.getStaticObjects().add(new PlatformerWall(1, 11));
        level.getStaticObjects().add(new PlatformerWall(2, 11));
        level.getStaticObjects().add(new PlatformerWall(3, 11));
        level.getStaticObjects().add(new PlatformerWall(4, 11));
        level.getStaticObjects().add(new PlatformerWall(1, 12));
        level.getStaticObjects().add(new PlatformerWall(2, 12));
        level.getStaticObjects().add(new PlatformerWall(3, 12));
        level.getStaticObjects().add(new PlatformerWall(4, 12));
        level.getStaticObjects().add(new PlatformerWall(1, 13));
        level.getStaticObjects().add(new PlatformerWall(2, 13));
        level.getStaticObjects().add(new PlatformerWall(3, 13));
        level.getStaticObjects().add(new PlatformerWall(4, 13));

        level.getStaticObjects().add(new PlatformerWall(11, 11));
        level.getStaticObjects().add(new PlatformerWall(12, 11));
        level.getStaticObjects().add(new PlatformerWall(13, 11));
        level.getStaticObjects().add(new PlatformerWall(14, 11));
        level.getStaticObjects().add(new PlatformerWall(11, 12));
        level.getStaticObjects().add(new PlatformerWall(12, 12));
        level.getStaticObjects().add(new PlatformerWall(13, 12));
        level.getStaticObjects().add(new PlatformerWall(14, 12));
        level.getStaticObjects().add(new PlatformerWall(11, 13));
        level.getStaticObjects().add(new PlatformerWall(12, 13));
        level.getStaticObjects().add(new PlatformerWall(13, 13));
        level.getStaticObjects().add(new PlatformerWall(14, 13));

        level.getStaticObjects().add(new PlatformerWall(17, 13));
        level.getStaticObjects().add(new PlatformerWall(17, 12));
        level.getStaticObjects().add(new PlatformerWall(17, 11));
        level.getStaticObjects().add(new PlatformerWall(17, 10));

        level.getStaticObjects().add(new PlatformerWall(20, 13));
        level.getStaticObjects().add(new PlatformerWall(20, 12));
        level.getStaticObjects().add(new PlatformerWall(20, 11));
        level.getStaticObjects().add(new PlatformerWall(20, 10));
        level.getStaticObjects().add(new PlatformerWall(20, 9));

        level.getStaticObjects().add(new PlatformerWall(23, 13));
        level.getStaticObjects().add(new PlatformerWall(23, 12));
        level.getStaticObjects().add(new PlatformerWall(23, 11));
        level.getStaticObjects().add(new PlatformerWall(23, 10));
        level.getStaticObjects().add(new PlatformerWall(23, 9));
        level.getStaticObjects().add(new PlatformerWall(23, 8));

        level.getStaticObjects().add(new PlatformerWall(27, 7));
        level.getStaticObjects().add(new PlatformerWall(28, 7));
        level.getStaticObjects().add(new PlatformerWall(29, 7));
        level.getStaticObjects().add(new PlatformerWall(29, 6));
        level.getStaticObjects().add(new PlatformerWall(29, 5));

        level.getStaticObjects().add(new PlatformerWall(19, 3));
        level.getStaticObjects().add(new PlatformerWall(20, 3));
        level.getStaticObjects().add(new PlatformerWall(21, 3));
        level.getStaticObjects().add(new PlatformerWall(22, 3));
        level.getStaticObjects().add(new PlatformerWall(23, 3));
        level.getStaticObjects().add(new PlatformerWall(24, 3));
        level.getStaticObjects().add(new PlatformerWall(25, 3));

        level.getStaticObjects().add(new Spike(5, 12));
        level.getStaticObjects().add(new Spike(6, 12));
        level.getStaticObjects().add(new Spike(7, 12));
        level.getStaticObjects().add(new Spike(8, 12));
        level.getStaticObjects().add(new Spike(9, 12));
        level.getStaticObjects().add(new Spike(10, 12));
        level.getStaticObjects().add(new Spike(5, 13));
        level.getStaticObjects().add(new Spike(6, 13));
        level.getStaticObjects().add(new Spike(7, 13));
        level.getStaticObjects().add(new Spike(8, 13));
        level.getStaticObjects().add(new Spike(9, 13));
        level.getStaticObjects().add(new Spike(10, 13));

        level.getStaticObjects().add(new Spike(15, 13));
        level.getStaticObjects().add(new Spike(16, 13));
        level.getStaticObjects().add(new Spike(18, 13));
        level.getStaticObjects().add(new Spike(19, 13));
        level.getStaticObjects().add(new Spike(21, 13));
        level.getStaticObjects().add(new Spike(22, 13));

        level.getStaticObjects().add(new Spike(24, 9));
        level.getStaticObjects().add(new Spike(25, 9));
        level.getStaticObjects().add(new Spike(26, 9));
        level.getStaticObjects().add(new Spike(27, 9));
        level.getStaticObjects().add(new Spike(28, 9));
        level.getStaticObjects().add(new Spike(29, 9));
        level.getStaticObjects().add(new Spike(30, 9));
        level.getStaticObjects().add(new Spike(24, 10));
        level.getStaticObjects().add(new Spike(25, 10));
        level.getStaticObjects().add(new Spike(26, 10));
        level.getStaticObjects().add(new Spike(27, 10));
        level.getStaticObjects().add(new Spike(28, 10));
        level.getStaticObjects().add(new Spike(29, 10));
        level.getStaticObjects().add(new Spike(30, 10));
        level.getStaticObjects().add(new Spike(24, 11));
        level.getStaticObjects().add(new Spike(25, 11));
        level.getStaticObjects().add(new Spike(26, 11));
        level.getStaticObjects().add(new Spike(27, 11));
        level.getStaticObjects().add(new Spike(28, 11));
        level.getStaticObjects().add(new Spike(29, 11));
        level.getStaticObjects().add(new Spike(30, 11));
        level.getStaticObjects().add(new Spike(24, 12));
        level.getStaticObjects().add(new Spike(25, 12));
        level.getStaticObjects().add(new Spike(26, 12));
        level.getStaticObjects().add(new Spike(27, 12));
        level.getStaticObjects().add(new Spike(28, 12));
        level.getStaticObjects().add(new Spike(29, 12));
        level.getStaticObjects().add(new Spike(30, 12));
        level.getStaticObjects().add(new Spike(24, 13));
        level.getStaticObjects().add(new Spike(25, 13));
        level.getStaticObjects().add(new Spike(26, 13));
        level.getStaticObjects().add(new Spike(27, 13));
        level.getStaticObjects().add(new Spike(28, 13));
        level.getStaticObjects().add(new Spike(29, 13));
        level.getStaticObjects().add(new Spike(30, 13));

        return level;
    }

    public Level extraLevelDX(){
        Level level = new PlatformerLevel(this, 12, 12, "spikes and such");

        level.getStaticObjects().add(new PlatformerWall(4,3));
        level.getStaticObjects().add(new PlatformerWall(5,3));
        level.getStaticObjects().add(new PlatformerWall(6,3));

        level.getDynamicObjects().add(new Potion(new Vector2D(5,2), 7));

        level.getStaticObjects().add(new PlatformerWall(4,7));
        level.getStaticObjects().add(new PlatformerWall(5,7));
        level.getStaticObjects().add(new PlatformerWall(6,7));

        level.getDynamicObjects().add(new Potion(new Vector2D(5,6), -5));

        level.getStaticObjects().add(new PlatformerWall(2,6));
        level.getStaticObjects().add(new PlatformerWall(1,9));




        level.getStaticObjects().add(new PlatformerWall(9,9));
        level.getStaticObjects().add(new PlatformerWall(10,9));
        level.getStaticObjects().add(new PlatformerWall(9,10));
        level.getStaticObjects().add(new PlatformerWall(10,10));





        level.getStaticObjects().add(new Spike(1,10));
        level.getStaticObjects().add(new Spike(2,10));
        level.getStaticObjects().add(new Spike(3,10));
        level.getStaticObjects().add(new Spike(4,10));
        level.getStaticObjects().add(new Spike(5,10));
        level.getStaticObjects().add(new Spike(6,10));
        level.getStaticObjects().add(new Spike(7,10));
        level.getStaticObjects().add(new Spike(8,10));



        level.getStaticObjects().add(new Goal(1, 8, this));

        level.getPlayerStartLocation().setX(9.5);
        level.getPlayerStartLocation().setY(7);



        return level;
    }

    public Level levelFour() {
        Level level = new PlatformerLevel(this, 19, 16, "pl_level1");

        level.getStaticObjects().add(new PlatformerWall(1, 3));
        level.getStaticObjects().add(new PlatformerWall(2, 3));
        level.getStaticObjects().add(new PlatformerWall(3, 3));
        level.getStaticObjects().add(new PlatformerWall(4, 3));
        level.getStaticObjects().add(new PlatformerWall(5, 3));
        level.getStaticObjects().add(new PlatformerWall(6, 3));

        level.getStaticObjects().add(new PlatformerWall(9, 5));
        level.getStaticObjects().add(new PlatformerWall(10, 5));
        level.getStaticObjects().add(new PlatformerWall(11, 5));
        level.getStaticObjects().add(new PlatformerWall(12, 5));
        level.getStaticObjects().add(new PlatformerWall(17, 7));

        level.getStaticObjects().add(new PlatformerWall(5, 11));
        level.getStaticObjects().add(new PlatformerWall(6, 11));
        level.getStaticObjects().add(new PlatformerWall(7, 11));
        level.getStaticObjects().add(new PlatformerWall(8, 11));
        level.getStaticObjects().add(new PlatformerWall(9, 11));
        level.getStaticObjects().add(new PlatformerWall(10, 11));

        level.getStaticObjects().add(new PlatformerWall(15, 10));
        level.getStaticObjects().add(new PlatformerWall(16, 10));
        level.getStaticObjects().add(new PlatformerWall(17, 10));
        level.getStaticObjects().add(new PlatformerWall(15, 11));
        level.getStaticObjects().add(new PlatformerWall(16, 11));
        level.getStaticObjects().add(new PlatformerWall(17, 11));
        level.getStaticObjects().add(new PlatformerWall(15, 12));
        level.getStaticObjects().add(new PlatformerWall(16, 12));
        level.getStaticObjects().add(new PlatformerWall(17, 12));
        level.getStaticObjects().add(new PlatformerWall(15, 13));
        level.getStaticObjects().add(new PlatformerWall(16, 13));
        level.getStaticObjects().add(new PlatformerWall(17, 13));
        level.getStaticObjects().add(new PlatformerWall(15, 14));
        level.getStaticObjects().add(new PlatformerWall(16, 14));
        level.getStaticObjects().add(new PlatformerWall(17, 14));
        level.getStaticObjects().add(new PlatformerWall(15, 15));
        level.getStaticObjects().add(new PlatformerWall(16, 15));
        level.getStaticObjects().add(new PlatformerWall(17, 15));

        level.getStaticObjects().add(new PlatformerWall(1, 14));
        level.getStaticObjects().add(new PlatformerWall(2, 14));
        level.getStaticObjects().add(new PlatformerWall(3, 14));

        level.getStaticObjects().add(new Goal(2, 2, this));

        level.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 6.0)));
        level.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 12.0)));
        level.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 10.0)));
        level.getDynamicObjects().add(new Enemy(new Vector2D(4.0, 6.0)));



        level.getPlayerStartLocation().setX(9.0);
        level.getPlayerStartLocation().setY(14.0);

        return level;
    }

    public Level EndingLevel(){

        Level level = new PlatformerLevel(this, 10, 10, "platformer_Win_:)");
        level.getStaticObjects().add(new PlatformerWall(8,1));
        level.getStaticObjects().add(new PlatformerWall(1,1));


        level.getStaticObjects().add(new PlatformerWall(3,2));
        level.getStaticObjects().add(new PlatformerWall(3,3));

        level.getStaticObjects().add(new PlatformerWall(6,2));
        level.getStaticObjects().add(new PlatformerWall(6,3));


        level.getStaticObjects().add(new PlatformerWall(2,5));
        level.getStaticObjects().add(new PlatformerWall(3,6));
        level.getStaticObjects().add(new PlatformerWall(3,7));
        level.getStaticObjects().add(new PlatformerWall(4,7));
        level.getStaticObjects().add(new PlatformerWall(5,7));
        level.getStaticObjects().add(new PlatformerWall(6,7));
        level.getStaticObjects().add(new PlatformerWall(6,6));
        level.getStaticObjects().add(new PlatformerWall(7,5));

        level.getStaticObjects().add(new PlatformerWall(8,8));
        level.getStaticObjects().add(new PlatformerWall(1,8));


        level.getPlayerStartLocation().setX(4.5);
        level.getPlayerStartLocation().setY(5.0);


        return level;
    }


}
