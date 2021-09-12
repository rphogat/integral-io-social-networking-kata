package domain;


public class User {

    private String name;
    private Wall wall;

    public User(String name) {
        this.name = name;
        this.wall = new Wall();
    }

    public String getName() {
        return name;
    }

    public Wall getWall(){
        return this.wall;
    }

}
