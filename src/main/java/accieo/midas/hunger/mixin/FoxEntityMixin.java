package accieo.midas.hunger.mixin;

import accieo.midas.hunger.entities.goals.fox.EatSweetGoldenBerriesGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoxEntity.class)
public abstract class FoxEntityMixin extends AnimalEntity {
    public FoxEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    protected void initGoalsMixed(CallbackInfo ci) {
        this.goalSelector.add(1, new EatSweetGoldenBerriesGoal((FoxEntity)(Object)this, 1.2f, 12, 1));
    }

}
