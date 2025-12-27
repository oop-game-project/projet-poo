package com.game.building;

	import com.game.core.Upgradable;

	public abstract class Building implements Upgradable {

	    protected String name;
	    protected int level;
	    protected int cost;

	    public Building(String name, int cost) {
	        this.name = name;
	        this.cost = cost;
	        this.level = 1;
	    }

	    @Override
	    public void upgrade() {
	        level++;
	        System.out.println(name + " upgraded to level " + level);
	    }
	}


