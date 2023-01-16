package no.ntnu.sigvebjo.gridsystem;

public abstract class GridItem {
    private int positionX;
    private int positionY;

    public GridItem(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
