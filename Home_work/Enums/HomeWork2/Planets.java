package Home_work.Enums.HomeWork2;

public enum Planets {
    MERCURY(330,2439,69),
    VENUS(4868,6050,109),
    EARTH(5973,6371,152),
    MARS(641,3389,249),
    JUPITER(1898600,69911,816),
    SATURN(568460,58232,1500),
    URANUS(86832,25362,3000),
    NEPTUNE(102430,24622,4500);
    private int weight; //*10`21
    private int radius; //км
    private int orbitalRadius; //млн. км

    Planets(int weight, int radius, int orbitalRadius) {
        this.weight = weight;
         this.radius = radius;
         this.orbitalRadius = orbitalRadius;
    }

    public int getWeight() {
        return weight;

    }

    public int getRadius() {
        return radius;
    }

    public int getOrbitalRadius() {
        return orbitalRadius;
    }
}
