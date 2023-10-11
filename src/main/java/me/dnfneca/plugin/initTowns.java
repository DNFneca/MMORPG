package me.dnfneca.plugin;

import me.dnfneca.plugin.utilities.managers.Mayors.Mayor;
import me.dnfneca.plugin.utilities.managers.Towns.Town;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static me.dnfneca.plugin.Plugin.*;

public enum initTowns {
	;

	public static void init() {
		Statement statement;
		if(connection != null) {
			try {
				statement = connection.createStatement();
				if (statement.execute("SELECT * FROM `towns`")) {
					ResultSet results = statement.getResultSet();
					int nameIndex = results.findColumn("Name");
					int distanceIndex = results.findColumn("Distance");
					int xIndex = results.findColumn("x");
					int yIndex = results.findColumn("y");
					int zIndex = results.findColumn("z");
					while (results.next()) {
						int Distance = results.getInt(2);
						double x = results.getDouble(3);
						double y = results.getDouble(4);
						double z = results.getDouble(5);
						String Mayor = results.getString(6);

						System.out.println(results.getString("Name"));

						World w = Bukkit.getWorlds().get(0);

						Location loc = new Location(w, x, y, z);

						new Town(results.getString("Name"), loc, results.getInt(2), Mayor);


						if(Towns.size() > 1) {
							System.out.println(Towns.get(0).getTownName());
							System.out.println(Towns.get(1).getTownName());
						} else {
							System.out.println(Towns.get(0).getTownName());

						}

					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
