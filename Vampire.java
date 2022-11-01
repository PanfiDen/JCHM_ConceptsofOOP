public class Vampire extends Enemy{

    String nameEnemy;
    private int damage = 5;
    static boolean isSecondAttack = false;


    public Vampire(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if(getHealth() > 0) {
            System.out.println("Vampire attacks a " + hero.getTypeHero());
            hero.takeDamage(damage);
            if (isSecondAttack) {
                superPower();
            }
            isSecondAttack = !isSecondAttack;
        }
    }

    @Override
    public void takeDamage(int damage){
        setHealth(getHealth() - damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
        System.out.println("Hero inflicts " + damage + " points on the vampire damage");
        System.out.println("Vampire has" + getHealth() + " health left" + "\n" + "----------------------------------------------");
    }

    @Override
    public String getNameEnemy() {
        return nameEnemy = "Vampire";
    }

    public void superPower(){
        setHealth(getHealth() + 3);
        System.out.println("The vampire restores 3 units of health");
        System.out.println("Vampire has" + getHealth() + " health left" + "\n" + "----------------------------------------------");

    }


}
