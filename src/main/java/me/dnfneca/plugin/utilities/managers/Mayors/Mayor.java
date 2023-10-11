package me.dnfneca.plugin.utilities.managers.Mayors;

import me.dnfneca.plugin.utilities.managers.Towns.Town;

import static me.dnfneca.plugin.Plugin.Mayors;

public class Mayor {

	String MayorName, Buff;
	MayorEvent mayorEvent;

	public Mayor(String Name, String Buff, MayorEvent mayorEvent) {
		this.MayorName = Name;
		this.Buff = Buff;
		this.mayorEvent = mayorEvent;
		Mayors.add(this);
	}

	public String getBuff() {
		return this.Buff;
	}

	public MayorEvent getMayorEvent() {
		return this.mayorEvent;
	}

	public static Mayor getMayorByName(String Name) {
		for (Mayor m: Mayors) {
			if(m.getMayorName().equals(Name)) {
				return m;
			}
		}
		return null;
	}

	public String getMayorName() {
		return this.MayorName;
	}
}

