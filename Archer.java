public class Archer extends Hero{
    static int damage = 8;
    public Archer(String name, int health) {
        super(name, health);
    }

    String typeHero = "������";

    @Override
    public String getTypeHero() {
        return typeHero;
    }

    @Override
    public void attackEnemy(Enemy enemy){
        System.out.println("������ ����� " + enemy.getNameEnemy());
        enemy.takeDamage(damage);
    }
}
