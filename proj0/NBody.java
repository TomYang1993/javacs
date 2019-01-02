public class NBody {
    public static double readRadius(String path){
        In in = new In("./data/planets.txt");
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String path){
        In in = new In("./data/planets.txt");
        int universeSize = in.readInt();
        Planet[] planets = new Planet[universeSize];
        for(int j = 0; j < universeSize; j++){
            planets[j] = new Planet();
        }
        in.readDouble();
        int i = 0;
        while(!in.isEmpty()){
            if(i == 5) break;
            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass = in.readDouble();
            planets[i].imgFileName = in.readString();
            i += 1;
        }
        return planets;
    }
}
