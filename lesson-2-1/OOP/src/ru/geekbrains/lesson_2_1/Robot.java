package ru.geekbrains.lesson_2_1;


public class Robot implements SimpleAbilities {

    protected String name;
    protected int jumpingSkill;
    protected int runningSkill;

    public Robot(String name, int jumpingSkill, int runningSkill) {
        this.name = name;
        this.jumpingSkill = jumpingSkill;
        this.runningSkill = runningSkill;
    }

    public String getName() {
        return name;
    }

    public int getJumpingSkill() {
        return jumpingSkill;
    }

    public int getRunningSkill() {
        return runningSkill;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s is running.", name));
    }

    @Override
    public void jump() {
        System.out.println(String.format("%s is jumping.", name));
    }
}
