import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Hero hero = null;
        System.out.println("Придумайте нікнейм");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();
        System.out.println("Ласкаво просимо, " + nickname + "!" + "\n" + "Оберіть будь ласка клас, ввівши число від 1 до 3");
        System.out.println("[1] Воїн;" + "[2] Маг;" + "[3] Лучник;");


        int typeHero;
        do {
            Scanner scanner1 = new Scanner(System.in);
            typeHero = scanner1.nextInt();
            if (typeHero == 1) {
                System.out.println("Ви обрали клас Воїн!");
                hero = new Warrior(nickname, 50);
            } else if (typeHero == 2) {
                System.out.println("Ви обрали клас Маг!");
                hero = new Mage(nickname, 50);
            } else if (typeHero == 3) {
                System.out.println("Ви обрали клас Лучник");
                hero = new Archer(nickname, 50);
            } else {
                System.out.println("Ви ввели некоректне число, повторіть спробу!");
            }
        } while (typeHero < 1 || typeHero > 3);



        System.out.println("""
                    Ласкаво просимо на арену!
                    Ваш перший ворог буде Привид
                    Що будете робити?
                    [1] Актакувати його
                    [2] Блокувати атаку""");

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
                        Ваш крок!
                        Що будете робити?
                        [1] Актакувати його
                        [2] Блокувати атаку""");
            }
        }
        if(hero.isAlive()){
            System.out.println("ВІТАЮ З ПЕРЕМОГОЮ!!!" + "\n" + "------------------------------------------------------------------------------------------");
        }
        System.out.println("\n" + "Лікар залатав Ваші рани та восполнив Вам 50 од здоров'я");
        hero.takeDamage(-50);

        System.out.println("""
                
                На арену виходить 3 вороги
                Що будете робити?
                [1] Атакувати
                [2] Блокувати атаку""");

        Enemy ghost1 = new Ghost(15);
        Enemy vampire = new Vampire(15);
        Enemy zombie = new Zombie(20);


        while(hero.isAlive() && ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()) {
            Scanner scanner2 = new Scanner(System.in);
            int attack = scanner2.nextInt();
            if (attack == 1) {
                System.out.println("Кого хочете атакувати?");
                if (ghost1.isAlive()) {
                    System.out.println("[1] Привида");
                }
                if (vampire.isAlive()) {
                    System.out.println("[2] Вампіра");
                }
                if (zombie.isAlive()) {
                    System.out.println("[3] Зомбі");
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
                System.out.println("Нажаль Ви програли, спробуйте в інший раз...");
                break;
            } else if (ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()){
                    System.out.println("""
                            Ваш крок!
                            Що будете робити?
                            [1] Актакувати
                            [2] Блокувати атаку""");
            }

        }
        if(hero.isAlive() && !ghost1.isAlive() && !vampire.isAlive() && !zombie.isAlive()){
            System.out.println("ВІТАЮ З ПЕРЕМОГОЮ!!!");
        }

    }
}
