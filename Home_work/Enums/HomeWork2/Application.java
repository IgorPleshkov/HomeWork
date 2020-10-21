package Home_work.Enums.HomeWork2;

public class Application {
    public static void main(String[] args) {
        Planets[] planets = Planets.values();
        for (Planets p : planets){
            System.out.println(p.name() +
                    " масса(*10^21кг): " + p.getWeight() +
                    " Радиус(км): " + p.getRadius() +
                    " Орбитальный радиус(млн. км): " + p.getOrbitalRadius());
        }
    }
}
