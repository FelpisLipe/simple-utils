package com.felpslipe.simple_utils.block;

import com.felpslipe.simple_utils.SimpleUtils;
import com.felpslipe.simple_utils.item.SimpleItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SimpleBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SimpleUtils.MOD_ID);

    public static final DeferredBlock<DirtPathBlock> MASHED_PULP = registerBlock("mashed_pulp",
            () -> new DirtPathBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.MUD)));
    public static final DeferredBlock<Block> UNPROCESSED_NETHERRACK = registerBlock("unprocessed_netherrack",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.PACKED_MUD)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SimpleItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Registering blocks
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
