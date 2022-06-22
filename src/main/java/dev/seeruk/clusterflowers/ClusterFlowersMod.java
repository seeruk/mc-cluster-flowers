package dev.seeruk.clusterflowers;

import dev.seeruk.clusterflowers.block.ClusterFlowerBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClusterFlowersMod implements ModInitializer {
	private static final AbstractBlock.Settings flowerSettings = FabricBlockSettings.of(Material.PLANT)
			.breakInstantly()
			.noCollision()
			.offsetType(AbstractBlock.OffsetType.XZ)
			.sounds(BlockSoundGroup.GRASS);

	public static final ClusterFlowerBlock CLUSTER_RED_TULIP = new ClusterFlowerBlock(flowerSettings);

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("clusterflowers");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello from Cluster Flowers!");

		this.registerFlower(CLUSTER_RED_TULIP, "cluster_red_tulip");
	}

	private void registerFlower(ClusterFlowerBlock block, String name) {
		Registry.register(Registry.BLOCK, new Identifier("clusterflowers", name), block);
		Registry.register(Registry.ITEM, new Identifier("clusterflowers", name), new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)));
	}
}
