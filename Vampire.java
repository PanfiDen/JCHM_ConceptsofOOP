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
            System.out.println("Вампір атакує " + hero.getTypeHero());
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
        System.out.println("Герой завдає вампіру " + damage + " од. шкоди");
        System.out.println("У вампіра залишлось " + getHealth() + " здоров'я " + "\n" + "----------------------------------------------");
    }

    @Override
    public String getNameEnemy() {
        return nameEnemy = "Вампір";
    }

    public void superPower(){
        setHealth(getHealth() + 3);
        System.out.println("Вампір восстановлює 3 од. здоров'я");
        System.out.println("У вампіра залишлось " + getHealth() + " здоров'я" + "\n" + "----------------------------------------------");

    }


}
