
package net.mcreator.onepunchmanmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.onepunchmanmod.procedures.SaitamasHeroOutfitBootsTickEventProcedure;
import net.mcreator.onepunchmanmod.procedures.SaitamasHeroOutfitBodyTickEventProcedure;
import net.mcreator.onepunchmanmod.OnepunchmanmodModElements;

import java.util.Map;
import java.util.HashMap;

@OnepunchmanmodModElements.ModElement.Tag
public class SaitamasHeroOutfitItem extends OnepunchmanmodModElements.ModElement {
	@ObjectHolder("onepunchmanmod:saitamasherooutfit_helmet")
	public static final Item helmet = null;
	@ObjectHolder("onepunchmanmod:saitamasherooutfit_chestplate")
	public static final Item body = null;
	@ObjectHolder("onepunchmanmod:saitamasherooutfit_leggings")
	public static final Item legs = null;
	@ObjectHolder("onepunchmanmod:saitamasherooutfit_boots")
	public static final Item boots = null;
	public SaitamasHeroOutfitItem(OnepunchmanmodModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{200, 200, 200, 200}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 10;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "saitamasherooutfit";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "onepunchmanmod:textures/models/armor/saitama__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					SaitamasHeroOutfitBodyTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("saitamasherooutfit_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "onepunchmanmod:textures/models/armor/saitama__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("saitamasherooutfit_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "onepunchmanmod:textures/models/armor/saitama__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					SaitamasHeroOutfitBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("saitamasherooutfit_boots"));
	}
}
