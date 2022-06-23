package dev.seeruk.clusterflowers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClusterFlowersClientMod implements ClientModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("clusterflowers");

    @Override
    public void onInitializeClient() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello from Cluster Flowers client!");

        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_DANDELION, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_BLUE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_ALLIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_AZURE_BLUET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_RED_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_ORANGE_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_WHITE_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_PINK_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_OXEYE_DAISY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_CORNFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_LILY_OF_THE_VALLEY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ClusterFlowersMod.CLUSTER_WITHER_ROSE, RenderLayer.getCutout());
    }
}
