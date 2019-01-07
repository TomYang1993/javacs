public class Planet {


    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;


    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public Planet(){
        this.xxPos = 0;
        this.yyPos = 0;
        this.xxVel = 0;
        this.yyVel = 0;
        this.mass = 0;
        this.imgFileName = "";
    }

    public double calcDistance(Planet target){
        double distance = (target.xxPos - this.xxPos) * (target.xxPos - this.xxPos) + (target.yyPos - this.yyPos) * (target.yyPos - this.yyPos);
        return Math.sqrt(distance);
    }

    public double calcForceExertedBy(Planet target){
        double exertedForce = G * this.mass * target.mass / (this.calcDistance(target) * this.calcDistance(target));
        return exertedForce;
    }

    public double calcForceExertedByX(Planet target){
        double forceX = calcForceExertedBy(target) * (target.xxPos - this.xxPos) / calcDistance(target);
        return forceX;
    }

    public double calcForceExertedByY(Planet target){
        double forceY = calcForceExertedBy(target) * (target.yyPos - this.yyPos) / calcDistance(target);
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double netForceX = 0.0;
        for(Planet p:planets){
            if(p.equals(this)){
                continue;
            }
            netForceX = netForceX + this.calcForceExertedByX(p);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netForceY = 0.0;
        for(Planet p:planets){
            if(p.equals(this)){
                continue;
            }
            netForceY = netForceY + this.calcForceExertedByY(p);
        }
        return netForceY;
    }

    public void update(double time, double forceX, double forceY ){
        double ax = forceX / this.mass;
        double ay = forceY / this.mass;
        this.xxVel = this.xxVel + time * ax;
        this.yyVel = this.yyVel + time * ay;
        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
    
}
