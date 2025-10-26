package dev.chemthunder.arcturus.index;

import dev.chemthunder.arcturus.Arcturus;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public interface ArcturusItemGroups {
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Arcturus.id("arcturus"));
    ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ArcturusItems.DECADENCE))
            .displayName(Text.translatable("itemGroup.arcturus").styled(style -> style.withColor(0xbd00d8)))
            .build();

    static void init() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(ArcturusItemGroups::addEntries);

    }

    private static void addEntries(FabricItemGroupEntries itemGroup) {
        itemGroup.add(ArcturusItems.DECADENCE);
        itemGroup.add(ArcturusItems.DAMNED_BOOK);
        itemGroup.add(ArcturusItems.STARLIGHT_SHARD);
        itemGroup.add(ArcturusItems.SHATTERED_DECADENCE);
        itemGroup.add(ArcturusItems.TATTERED_DAMNED_BOOK);


        //testing
//        itemGroup.add(BulwarkBlocks.BUDDING_KLAPROTH);
//        itemGroup.add(BulwarkBlocks.OMINOUS_CATALYST);
//        itemGroup.add(BulwarkItems.DENTIST);
    }
}
