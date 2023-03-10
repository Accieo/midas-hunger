package accieo.midas.hunger.mixin;

import accieo.midas.hunger.entities.goals.fox.EatSweetGoldenBerriesGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Fox.class)
public abstract class FoxMixin extends Animal {

    protected FoxMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void initGoalsMixed(CallbackInfo ci) {
        this.goalSelector.addGoal(1, new EatSweetGoldenBerriesGoal((Fox)(Object)this, 1.2f, 12, 1));
    }

}
