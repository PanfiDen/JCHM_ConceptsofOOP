import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Hero hero = null;
        System.out.println("���������� ������");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();
        System.out.println("������� �������, " + nickname + "!" + "\n" + "������ ���� ����� ����, ����� ����� �� 1 �� 3");
        System.out.println("[1] ���;" + "[2] ���;" + "[3] ������;");


        int typeHero;
        do {
            Scanner scanner1 = new Scanner(System.in);
            typeHero = scanner1.nextInt();
            if (typeHero == 1) {
                System.out.println("�� ������ ���� ���!");
                hero = new Warrior(nickname, 50);
            } else if (typeHero == 2) {
                System.out.println("�� ������ ���� ���!");
                hero = new Mage(nickname, 50);
            } else if (typeHero == 3) {
                System.out.println("�� ������ ���� ������");
                hero = new Archer(nickname, 50);
            } else {
                System.out.println("�� ����� ���������� �����, �������� ������!");
            }
        } while (typeHero < 1 || typeHero > 3);



        System.out.println("""
                    ������� ������� �� �����!
                    ��� ������ ����� ���� ������
                    �� ������ ������?
                    [1] ���������� ����
                    [2] ��������� �����""");

        Enemy ghost = new Ghost (15);

        while(hero.isAlive() && ghost.isAlive()) {
            Scanner scanner2 = new Scanner(System.in);
            int attack = scanner2.nextInt();
            if (attack == 1) {
                hero.attackEnemy(ghost);
                ghost.attackHero(hero);
            } else if (attack == 2) {
                hero.blockAttack(ghost);
                ghost.attackHero(hero);
            }
            if(ghost.isAlive()) {
                System.out.println("""
                        ��� ����!
                        �� ������ ������?
                        [1] ���������� ����
                        [2] ��������� �����""");
            }
        }
        if(hero.isAlive()){
            System.out.println("²��� � ���������!!!" + "\n" + "------------------------------------------------------------------------------------------");
        }
        System.out.println("\n" + "˳��� ������� ���� ���� �� ��������� ��� 50 �� ������'�");
        hero.takeDamage(-50);

        System.out.println("""
                
                �� ����� �������� 3 ������
                �� ������ ������?
                [1] ���������
                [2] ��������� �����""");

        Enemy ghost1 = new Ghost(15);
        Enemy vampire = new Vampire(15);
        Enemy zombie = new Zombie(20);


        while(hero.isAlive() && ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()) {
            Scanner scanner2 = new Scanner(System.in);
            int attack = scanner2.nextInt();
            if (attack == 1) {
                System.out.println("���� ������ ���������?");
                if (ghost1.isAlive()) {
                    System.out.println("[1] �������");
                }
                if (vampire.isAlive()) {
                    System.out.println("[2] ������");
                }
                if (zombie.isAlive()) {
                    System.out.println("[3] ����");
                }
                Scanner scanner3 = new Scanner(System.in);
                int whoAttack = scanner3.nextInt();

                if (whoAttack == 1) {
                    hero.attackEnemy(ghost1);
                }
                if (whoAttack == 2) {
                    hero.attackEnemy(vampire);
                }
                if (whoAttack == 3) {
                    hero.attackEnemy(zombie);
                }
                ghost1.attackHero(hero);
                vampire.attackHero(hero);
                zombie.attackHero(hero);
            } else if (attack == 2) {
                hero.blockAttack(ghost1);
                hero.blockAttack(vampire);
                hero.blockAttack(zombie);
                ghost1.attackHero(hero);
                vampire.attackHero(hero);
                zombie.attackHero(hero);
            }
            if (!hero.isAlive()) {
                System.out.println("������ �� ��������, ��������� � ����� ���...");
                break;
            } else if (ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()){
                    System.out.println("""
                            ��� ����!
                            �� ������ ������?
                            [1] ����������
                            [2] ��������� �����""");
            }

        }
        if(hero.isAlive() && !ghost1.isAlive() && !vampire.isAlive() && !zombie.isAlive()){
            System.out.println("²��� � ���������!!!");
        }

    }
}
