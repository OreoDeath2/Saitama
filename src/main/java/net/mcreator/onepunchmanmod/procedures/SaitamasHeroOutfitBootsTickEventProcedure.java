package net.mcreator.onepunchmanmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.onepunchmanmod.OnepunchmanmodModElements;

import java.util.Map;

@OnepunchmanmodModElements.ModElement.Tag
public class SaitamasHeroOutfitBootsTickEventProcedure extends OnepunchmanmodModElements.ModElement {
	public SaitamasHeroOutfitBootsTickEventProcedure(OnepunchmanmodModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SaitamasHeroOutfitBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 5));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 4));
	}
}
