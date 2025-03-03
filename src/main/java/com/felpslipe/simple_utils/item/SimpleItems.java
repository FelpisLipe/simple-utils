package com.felpslipe.simple_utils.item;

import com.felpslipe.simple_utils.SimpleUtils;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SimpleItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleUtils.MOD_ID);

    public static final DeferredItem<Item> CRIMSON_DUST = ITEMS.register("crimson_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_PULP = ITEMS.register("crimson_pulp",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
