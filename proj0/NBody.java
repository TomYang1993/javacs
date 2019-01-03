public class NBody {

    public static String starField = "./images/starfield.jpg";

    public static double readRadius(String path){
        In in = new In(path);
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
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

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        for (Planet p : planets) {
            System.out.println("Advice: " + p.xxPos + p.xxVel + p.yyPos + p.yyVel + p.mass + p.imgFileName);
        }

        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0, 0, starField);


        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        StdDraw.show();
        StdDraw.pause(2000);

        for (Planet p : planets) {
            p.draw();
        }
        


    }
}
