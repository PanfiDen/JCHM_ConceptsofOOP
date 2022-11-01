public class Mage extends Hero{
    static int damage = 9;

    String typeHero = "���";

    @Override
    public String getTypeHero() {
        return typeHero;
    }

    public Mage(String name, int health) {
        super(name, health);
    }


    @Override
    public void attackEnemy(Enemy enemy){
        System.out.println("��� ����� " + enemy.getNameEnemy());
        enemy.takeDamage(damage);
    }
}
