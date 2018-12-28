public class Shock {
    public static int bang;
    public static Shock baby;

    /** all properties are static, so instance level change will affect bang as well */
    public Shock() {
        this.bang = 100;
    }

    public Shock(int num) {
        this.bang = num;
        baby = starter();
        this.bang += num;
    }

    public static Shock starter() {
        Shock gear = new Shock();
        return gear;
    }

    public static void shrink(Shock statik) {
        statik.bang -= 1;
    }

    public static void main(String[] args) {
        Shock gear = new Shock(200);
        System.out.println(gear.bang);
        shrink(gear);
        shrink(starter());
        System.out.println(gear.bang);
    }
}