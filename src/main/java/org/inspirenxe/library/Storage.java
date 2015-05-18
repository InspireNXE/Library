package org.inspirenxe.library;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    // Stored as <library display name, book data>
    private static final Map<String, DataContainer> LIBRARY_MAP = new HashMap<>();

    public static void addBook(ItemStack stack) {
        // TODO: Review
        if (LIBRARY_MAP.containsKey(stack.getItem().getName())) {
            for (int i = 1; !LIBRARY_MAP.containsKey(stack.getItem().getName() + "." + i); i++) {
                LIBRARY_MAP.put(stack.getItem().getName() + "." + i, stack.toContainer());
            }
        }
    }

    public static ItemStack getBook(String title, String author) {
        return null;
    }

    public static Map<String, DataContainer> getLibrary() {
        return Collections.unmodifiableMap(LIBRARY_MAP);
    }
}
