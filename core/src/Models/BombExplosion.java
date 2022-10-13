package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion { //if extend Entity, BombExplosion and its center BombExplosionPositio// will cause collision with each other

    private List<Position> bombExplosionPositions = new ArrayList<>(1);
    private Position position;
    private INavigable navigation;
    int bombLength;

    public BombExplosion(Position position, int length, INavigable navigation){
        this.position = position;
        this.bombLength = length;
        this.navigation = navigation;
        createBombExplosionPositions(position, length);
        bombContact();}

    private void createBombExplosionPositions(Position position, int length) {
        
        bombExplosionPositions.add(new Position(position.getX(), position.getY()));
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX() + i, position.getY()));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX() - i, position.getY()));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX(), position.getY() + i));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX(), position.getY() - i));
        }

        /*
        int var = 4;
        for(int n = 0; n <= bombExplosionPositions.size(); n++){
            if(navigation.tryToKillEntity(bombExplosionPositions.get(n))){
                int var2 = 0;
                while(n+var2*var<bombExplosionPositions.size()){
                    bombExplosionPositions.remove(bombExplosionPositions.get(n+var*var2));
                    var2++;
                }
                var--;
            }
        }
         */
    }


    private void bombContact() {
        for (int i = 0; i < 4; i++){
            for (int j = 1; i <= bombLength; i++){
                if (navigation.tryToKillEntity(bombExplosionPositions.get(j*i+bombLength*i))){
                    break;
                }
            }
        }
    }

    public List<Position> getBombExplosionPositions() {
        return bombExplosionPositions;
    }

}
