package dev.chemthunder.arcturus.item;

import dev.chemthunder.arcturus.entity.MissileEntity;
import dev.chemthunder.arcturus.index.ArcturusEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DamnedBookItem extends Item {
    public DamnedBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (world instanceof ServerWorld serverWorld) {
                MissileEntity missile = new MissileEntity(ArcturusEntities.MISSILE_ENTITY, world);
                Vec3d pos = user.getPos();
                missile.updatePosition(pos.x, pos.y + 1.5f, pos.z);
                missile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 7.5F * 0.5F, 2.0F);

                serverWorld.spawnEntity(missile);
                missile.setOwner(user);
            }
            if (!user.isInCreativeMode()) {
                user.getItemCooldownManager().set(this.asItem(), 15);
            }
        return super.use(world, user, hand);
    }
}
