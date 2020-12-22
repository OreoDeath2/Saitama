
package net.mcreator.onepunchmanmod.item;

@OnepunchmanmodModElements.ModElement.Tag
public class SonicsKatanaItem extends OnepunchmanmodModElements.ModElement {

	@ObjectHolder("onepunchmanmod:sonics_katana")
	public static final Item block = null;

	public SonicsKatanaItem(OnepunchmanmodModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The Speed o sound sonic's katana"));
			}

		}.setRegistryName("sonics_katana"));
	}

}
