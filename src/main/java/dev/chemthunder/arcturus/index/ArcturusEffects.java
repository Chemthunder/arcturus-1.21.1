package dev.chemthunder.arcturus.index;

import dev.chemthunder.arcturus.Arcturus;
import dev.chemthunder.arcturus.effect.DespairEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public interface ArcturusEffects {
    RegistryEntry<StatusEffect> DESPAIR = create("despair", new DespairEffect(StatusEffectCategory.NEUTRAL, 0x0000));

    private static RegistryEntry<StatusEffect> create(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Arcturus.id(name), statusEffect);
    }

    static void initialize() {
    }
}