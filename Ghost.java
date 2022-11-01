public class Ghost extends Enemy{

    String nameEnemy;
    private int damage = 2;
    static boolean evenTakeDamage = false;

    public Ghost(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if(getHealth() >0) {
            System.out.println("Привид атакує " + hero.getTypeHero());
            hero.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int damage){
        if (evenTakeDamage){
            superPower();
        }else {
            setHealth(getHealth() - damage);
            if (getHealth() < 0) {
                setHealth(0);
            }
            System.out.println("Герой завдає Привид " + damage + " од. шкоди");
            System.out.println("У привида залишлось " + getHealth() + " здоров'я " + "\n" + "----------------------------------------------");
        }
        evenTakeDamage = !evenTakeDamage;
    }

    @Override
    public String getNameEnemy() {
        return nameEnemy = "Привид";
    }

    public void superPower(){
        System.out.println("Герой промахнувся!");
        System.out.println("У привида залишлось " + getHealth() + " здоров'я" + "\n" + "----------------------------------------------");

    }
}
