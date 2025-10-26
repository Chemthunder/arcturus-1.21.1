package dev.chemthunder.arcturus.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

//    @Inject(method = "applyMovementInput", at = @At("HEAD"), cancellable = true)
//    private void cancelMovement(Vec3d movementInput, float slipperiness, CallbackInfoReturnable<Vec3d> cir) {
//        if ((Object) this instanceof LivingEntity player) {
//            if (player.hasStatusEffect(ArcturusEffects.DESPAIR)) {
//                cir.setReturnValue(new Vec3d(0.25, 0.25, 0.25));
//            }
//        }
//    }
//
//    @Inject(method = "applyFluidMovingSpeed", at = @At("HEAD"), cancellable = true)
//    private void cancelFluidMovement(double gravity, boolean falling, Vec3d motion, CallbackInfoReturnable<Vec3d> cir) {
//        if ((Object) this instanceof LivingEntity player) {
//            if (player.hasStatusEffect(ArcturusEffects.DESPAIR)) {
//                cir.setReturnValue(new Vec3d(0.25, 0.25, 0.25));
//            }
//        }
//    }




}
