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
            System.out.println("����� ����� " + hero.getTypeHero());
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
        System.out.println("����� ����� ������ " + damage + " ��. �����");
        System.out.println("� ������ ��������� " + getHealth() + " ������'� " + "\n" + "----------------------------------------------");
    }

    @Override
    public String getNameEnemy() {
        return nameEnemy = "�����";
    }

    public void superPower(){
        setHealth(getHealth() + 3);
        System.out.println("����� ������������ 3 ��. ������'�");
        System.out.println("� ������ ��������� " + getHealth() + " ������'�" + "\n" + "----------------------------------------------");

    }


}
