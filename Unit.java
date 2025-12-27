package com.game.unit;

	import com.game.core.Attackable;
	import com.game.core.Drawable;

	public abstract class Unit implements Attackable, Drawable {

	    protected String name;
	    protected int health;
	    protected int attack;
	    protected int defense;
	    protected int range;

	    public Unit(String name, int health, int attack, int defense, int range) {
	        this.name = name;
	        this.health = health;
	        this.attack = attack;
	        this.defense = defense;
	        this.range = range;
	    }

	    public void attack(Unit enemy) {
	        int damage = Math.max(0, this.attack - enemy.defense);
	        enemy.takeDamage(damage);
	    }

	    @Override
	    public void takeDamage(int damage) {
	        health -= damage;
	    }

	    @Override
	    public boolean isAlive() {
	        return health > 0;
	    }
	}


