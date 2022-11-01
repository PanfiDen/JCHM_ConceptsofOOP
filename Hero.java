public abstract class Hero {
    private String name;
    int health;
    boolean isBlocked;


    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public boolean isAlive() {
        if (health > 0)
            return true;
        return false;
    }

    public int takeDamage(int damage){
        if(isBlocked){
            health -=  (damage/2);
            if (health < 0){
                health = 0;
            }
            System.out.println("У " + getTypeHero() + " залишлось " + health + " здоров'я" + "\n" + "----------------------------------------------");
            return health;
        }else {
            health -= damage;
            if (health < 0) {
                health = 0;
            }

            System.out.println("У " + getTypeHero() + " залишлось " + health + " здоров'я" + "\n" + "----------------------------------------------");
            return health;
        }
    }

    public abstract String getTypeHero();

    public abstract void attackEnemy(Enemy enemy);
    public void blockAttack(Enemy enemy){
        System.out.println(getTypeHero() + " блокує атаку " + enemy.getNameEnemy() + ", шкода зменшується вдвоє");
        isBlocked = !isBlocked;
    }

}
