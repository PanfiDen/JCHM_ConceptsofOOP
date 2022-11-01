import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Hero hero = null;
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();
        System.out.println("Welcome," + nickname + "!" + "\n" + "Please select a class and enter a number from 1 to 3");
        System.out.println("[1] Warrior;" + "[2] Mage;" + "[3] Archer;");


        int typeHero;
        do {
            Scanner scanner1 = new Scanner(System.in);
            typeHero = scanner1.nextInt();
            if (typeHero == 1) {
                System.out.println("You have chosen the Warrior class!");
                hero = new Warrior(nickname, 50);
            } else if (typeHero == 2) {
                System.out.println("You have chosen the Mage class!");
                hero = new Mage(nickname, 50);
            } else if (typeHero == 3) {
                System.out.println("You have chosen the Archer class!");
                hero = new Archer(nickname, 50);
            } else {
                System.out.println("You entered an incorrect number, please try again!");
            }
        } while (typeHero < 1 || typeHero > 3);



        System.out.println("""
                Welcome to the arena!
                Your first enemy will be a Ghost
                What will you do?
                [1] Attack
                [2] Block attack""");

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
                        Your step!
                        What will you do?
                        [1] Attack
                        [2] Block attack""");
            }
        }
        if(hero.isAlive()){
            System.out.println("CONGRATULATIONS ON WINNING!!!" + "\n" + "------------------------------------------------------------------------------------------");
        }
        System.out.println("\n" + "The doctor patched up your wounds and restore you to 50 health");
        hero.takeDamage(-50);

        System.out.println("""
                
                3 enemies enter the arena
                What will you do?
                [1] Attack
                [2] Block attack""");

        Enemy ghost1 = new Ghost(15);
        Enemy vampire = new Vampire(15);
        Enemy zombie = new Zombie(20);


        while(hero.isAlive() && ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()) {
            Scanner scanner2 = new Scanner(System.in);
            int attack = scanner2.nextInt();
            if (attack == 1) {
                System.out.println("Who do you want to attack?");
                if (ghost1.isAlive()) {
                    System.out.println("[1] Ghost");
                }
                if (vampire.isAlive()) {
                    System.out.println("[2] Vampire");
                }
                if (zombie.isAlive()) {
                    System.out.println("[3] Zombie");
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
                System.out.println("Unfortunately, you lost, try another time...");
                break;
            } else if (ghost1.isAlive() || vampire.isAlive() || zombie.isAlive()){
                    System.out.println("""
                        Your step!
                        What will you do?
                        [1] Attack
                        [2] Block attack""");
            }

        }
        if(hero.isAlive() && !ghost1.isAlive() && !vampire.isAlive() && !zombie.isAlive()){
            System.out.println("CONGRATULATIONS ON WINNING!!!");
        }

    }
}
