package me.dnfneca.plugin.utilities.managers.Mayors;

import me.dnfneca.plugin.utilities.managers.Towns.Town;

public class Mayor {

	String MayorName, Buff;
	Town Region;

	public Mayor(String Name, String Buff, Town Region) {
		this.MayorName = Name;
		this.Buff = Buff;
		this.Region = Region;
	}

	public String getBuff() {
		return this.Buff;
	}

	public String getMayorName() {
		return this.MayorName;
	}

	public Town getRegion() {
		return this.Region;
	}
}

