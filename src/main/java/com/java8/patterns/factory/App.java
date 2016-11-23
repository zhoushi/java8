package com.java8.patterns.factory;

/**
 * Created by Administrator on 2016/11/23.
 */
public class App {
    private final Blacksmith blacksmith;


    public App(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    public static void main(String[] args) {
        // Lets go to war with Orc weapons
        App app = new App(new OrcBlacksmith());
        app.manufactureWeapons();

        // Lets go to war with Elf weapons
        app = new App(new ElfBlacksmith());
        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon;
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(weapon);
        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println(weapon);
    }
}
