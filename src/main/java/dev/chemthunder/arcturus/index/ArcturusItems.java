package dev.chemthunder.arcturus.index;

import dev.chemthunder.arcturus.Arcturus;
import dev.chemthunder.arcturus.item.DamnedBookItem;
import dev.chemthunder.arcturus.item.DecadenceItem;
import dev.chemthunder.arcturus.item.ShatteredDecadenceItem;
import dev.chemthunder.arcturus.item.TatteredDamnedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ArcturusItems {
    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //  Item WEAPON_RACK = create("weapon_rack", new WeaponRackItem(new Item.Settings()));

    Item DAMNED_BOOK = create("damned_book", new DamnedBookItem(new Item.Settings()
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.UNCOMMON)
    ));

    Item STARLIGHT_SHARD = create("starlight_shard", new Item(new Item.Settings()
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.UNCOMMON)
    ));

    Item DECADENCE = create("decadence", new DecadenceItem(
            ToolMaterials.NETHERITE,

            new Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
            .fireproof()
                    .attributeModifiers(DecadenceItem.createAttributeModifiers())
    ));

    Item SHATTERED_DECADENCE = create("shattered_decadence", new ShatteredDecadenceItem(new Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ));

    Item TATTERED_DAMNED_BOOK = create("tattered_damned_book", new TatteredDamnedBookItem(new Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    ));

    static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, Arcturus.id(name));
        return item;
    }

    static void initialize() {
        ITEMS.forEach((item, id) -> Registry.register(Registries.ITEM, id, item));
    }

    /*
    / todo
    / simplify existing items
     */
}
