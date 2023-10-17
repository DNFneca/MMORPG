package me.dnfneca.plugin.utilities;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.*;

public class ItemStackType implements PersistentDataType<byte [], ItemStack[]> {
	@Override
	public Class<byte[]> getPrimitiveType() {
		return byte[].class;
	}

	@Override
	public Class<ItemStack[]> getComplexType() {
		return ItemStack[].class;
	}

	@Override
	public byte[] toPrimitive(ItemStack[] itemStacks, PersistentDataAdapterContext persistentDataAdapterContext) {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
		     ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(itemStacks);
			return bos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ItemStack[] fromPrimitive(byte[] bytes, PersistentDataAdapterContext persistentDataAdapterContext) {
		try{
			InputStream is = new ByteArrayInputStream(bytes);
			ObjectInputStream o = new ObjectInputStream(is);
			return (ItemStack[]) o.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

