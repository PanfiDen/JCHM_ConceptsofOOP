public class Warrior extends Hero{
    static int damage = 10;


    String typeHero = "Воїн";

    @Override
    public String getTypeHero() {
        return typeHero;
    }



    public Warrior(String name, int health) {
        super(name, health);
    }


    @Override
    public void attackEnemy(Enemy enemy){
        System.out.println("Воїн атакує " + enemy.getNameEnemy());
        enemy.takeDamage(damage);
    }
}
