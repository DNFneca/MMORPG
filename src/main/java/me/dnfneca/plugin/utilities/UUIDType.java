package me.dnfneca.plugin.utilities;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.UUID;

public class UUIDType implements PersistentDataType<byte [], UUID> {
	@Override
	public Class<byte[]> getPrimitiveType() {
		return byte[].class;
	}

	@Override
	public Class<UUID> getComplexType() {
		return UUID.class;
	}

	@Override
	public byte[] toPrimitive(UUID uuid, PersistentDataAdapterContext persistentDataAdapterContext) {
		return SerializationUtils.serialize(uuid);
	}

	@Override
	public UUID fromPrimitive(byte[] bytes, PersistentDataAdapterContext persistentDataAdapterContext) {
		try{
			InputStream is = new ByteArrayInputStream(bytes);
			ObjectInputStream o = new ObjectInputStream(is);
			return (UUID) o.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

