public class NBody {

    private static String starField = "./images/starfield.jpg";

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
            if(i == universeSize) break;
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

//        for (Planet p : planets) {
//            System.out.println("Advice: " + p.xxPos + p.xxVel + p.yyPos + p.yyVel + p.mass + p.imgFileName);
//        }

        StdDraw.setScale(-radius, radius);

        double timer = 0.0;

        while(timer < T){
            double[] forceX = new double[planets.length];
            double[] forceY = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                forceX[i] = planets[i].calcNetForceExertedByX(planets);
                forceY[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, forceX[i], forceY[i]);
            }

            StdDraw.picture(0, 0, starField);

            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(40);

            StdDraw.clear();

            timer = timer + dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
