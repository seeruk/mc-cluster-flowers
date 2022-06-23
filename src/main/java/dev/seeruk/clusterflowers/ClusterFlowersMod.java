package dev.seeruk.clusterflowers;

import dev.seeruk.clusterflowers.block.ClusterFlowerBlock;
import dev.seeruk.clusterflowers.block.ClusterWitherRoseBlock;
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

	public static final ClusterFlowerBlock CLUSTER_DANDELION = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_POPPY = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_BLUE_ORCHID = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_ALLIUM = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_AZURE_BLUET = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_RED_TULIP = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_ORANGE_TULIP = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_WHITE_TULIP = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_PINK_TULIP = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_OXEYE_DAISY = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_CORNFLOWER = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_LILY_OF_THE_VALLEY = new ClusterFlowerBlock(flowerSettings);
	public static final ClusterFlowerBlock CLUSTER_WITHER_ROSE = new ClusterWitherRoseBlock(flowerSettings);

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

		this.registerFlower(CLUSTER_DANDELION, "cluster_dandelion");
		this.registerFlower(CLUSTER_POPPY, "cluster_poppy");
		this.registerFlower(CLUSTER_BLUE_ORCHID, "cluster_blue_orchid");
		this.registerFlower(CLUSTER_ALLIUM, "cluster_allium");
		this.registerFlower(CLUSTER_AZURE_BLUET, "cluster_azure_bluet");
		this.registerFlower(CLUSTER_RED_TULIP, "cluster_red_tulip");
		this.registerFlower(CLUSTER_ORANGE_TULIP, "cluster_orange_tulip");
		this.registerFlower(CLUSTER_WHITE_TULIP, "cluster_white_tulip");
		this.registerFlower(CLUSTER_PINK_TULIP, "cluster_pink_tulip");
		this.registerFlower(CLUSTER_OXEYE_DAISY, "cluster_oxeye_daisy");
		this.registerFlower(CLUSTER_CORNFLOWER, "cluster_cornflower");
		this.registerFlower(CLUSTER_LILY_OF_THE_VALLEY, "cluster_lily_of_the_valley");
		this.registerFlower(CLUSTER_WITHER_ROSE, "cluster_wither_rose");
	}

	private void registerFlower(ClusterFlowerBlock block, String name) {
		Registry.register(Registry.BLOCK, new Identifier("clusterflowers", name), block);
		Registry.register(Registry.ITEM, new Identifier("clusterflowers", name), new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)));
	}
}
