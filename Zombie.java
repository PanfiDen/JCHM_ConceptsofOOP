public class Zombie extends Enemy{

    String nameEnemy;
    private int damage = 4;
    static boolean isReincarnation = false;

    public Zombie(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if(getHealth() > 0) {
            System.out.println("Зомбі атакує " + hero.getTypeHero());
            hero.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int damage){
            setHealth(getHealth() - damage);
            if (getHealth() < 0) {
                setHealth(0);
            }
            System.out.println("Герой завдає зомбі " + damage + " од. шкоди");
            System.out.println("У зомбі залишлось " + getHealth() + " здоров'я " + "\n" + "----------------------------------------------");
            if (getHealth() <= 0) {
                superPower();
            }
    }

    @Override
    public String getNameEnemy() {
        return nameEnemy = "Зомбі";
    }

    public void superPower(){
        if(!isReincarnation) {
            setHealth(20);
            System.out.println("Зомбі востає з мертвих");
            System.out.println("У зомбі залишлось " + getHealth() + " здоров'я" + "\n" + "----------------------------------------------");
            isReincarnation = !isReincarnation;
        }

    }

}
