package dev.chemthunder.arcturus.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class HeraldsHornItem extends Item {
    public HeraldsHornItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Box box = new Box(user.getBlockPos()).expand(5, 5, 5);
        List<LivingEntity> entities = world.getEntitiesByClass(
                LivingEntity.class, box,
                entity -> true
        );

        for (LivingEntity entity : entities) {
            if (entity != user) {
                entity.setVelocity(box.getCenter().subtract(entity.getPos()).multiply(-1.6));
                entity.addVelocity(0, 0.9f, 0);
            }
        }
        user.playSound(SoundEvents.ITEM_GOAT_HORN_PLAY, 1, 1);
        user.playSound(SoundEvents.BLOCK_SCULK_CATALYST_BREAK, 1, 1);
        return super.use(world, user, hand);
    }
}
