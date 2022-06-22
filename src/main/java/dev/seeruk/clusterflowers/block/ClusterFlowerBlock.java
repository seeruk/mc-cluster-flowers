package dev.seeruk.clusterflowers.block;

import dev.seeruk.clusterflowers.state.property.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * This file is part of the "mc-cluster-flowers" project.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <p>
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class ClusterFlowerBlock extends PlantBlock {
    public static final IntProperty FLOWERS = Properties.FLOWERS;
    public static final int MAX_FLOWERS = 4;

    protected static final VoxelShape ONE_FLOWER_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 10.0, 11.0);
    protected static final VoxelShape TWO_FLOWER_SHAPE = Block.createCuboidShape(3.0, 0.0, 4.0, 13.0, 10.0, 12.0);
    protected static final VoxelShape THREE_FLOWER_SHAPE = Block.createCuboidShape(2.0, 0.0, 0.0, 14.0, 10.0, 13.0);
    protected static final VoxelShape FOUR_FLOWER_SHAPE = Block.createCuboidShape(2.0, 0.0, 1.0, 16.0, 10.0, 13.0);

    // TODO: Stew effect? Would need stew recipes to be added.
    public ClusterFlowerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FLOWERS, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FLOWERS);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        switch (state.get(FLOWERS)) {
            default: {
                return ONE_FLOWER_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
            }
            case 2: {
                return TWO_FLOWER_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
            }
            case 3: {
                return THREE_FLOWER_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
            }
            case 4:
        }
        return FOUR_FLOWER_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.with(FLOWERS, Math.min(MAX_FLOWERS, blockState.get(FLOWERS) + 1));
        }
        return super.getPlacementState(ctx);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
        if (!ctx.shouldCancelInteraction() && ctx.getStack().isOf(this.asItem()) && state.get(FLOWERS) < MAX_FLOWERS) {
            return true;
        }
        return super.canReplace(state, ctx);
    }
}
