public enum Direction {
    LEFT(-1,0),
    RIGHT(1,0),
    UP(0,1),
    DOWN(0,-1);

    private int xCoordinate;
    private int yCoordinate;
    
    Direction(int xDirection, int yDirection ){
        this.xCoordinate = xDirection;
        this.yCoordinate = yDirection;
    }

    public int getXCoordinate(){
        return this.xCoordinate;
    }

    public int getYCoordinate(){
        return this.yCoordinate;
    }

    public String toString(){
        return String.format("[%d, %d]", this.xCoordinate, this.yCoordinate);
    }

}