public enum Option {
    EXIT('q', "Quitting the game", null),
    RESET('e', "Resetting the board", null),
    UP('w', "Moving up", Direction.UP),
    LEFT('a', "Moving left", Direction.LEFT),
    DOWN('s', "Moving down", Direction.DOWN),
    RIGHT('d', "Moving right", Direction.RIGHT);
    

    private char sign;
    private String description;
    private Direction direction;

    Option(char sign, String description, Direction direction){
        this.sign = sign;
        this.description = description;
        this.direction = direction;
    }

    public char getSign(){
        return sign;
    }

    public String getDescription(){
        return this.description;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public String toString(){
        return String.format("%c ==> option %s, %s", this.sign, this.name(), this.description);
    }

}
