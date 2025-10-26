package dev.chemthunder.arcturus.index;

import dev.chemthunder.arcturus.Arcturus;
import dev.chemthunder.arcturus.entity.MissileEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ArcturusEntities {

    EntityType<MissileEntity> MISSILE_ENTITY = create(
            "magic_missile",
            EntityType.Builder.create(
                    MissileEntity::new,
                    SpawnGroup.MISC
            ).dimensions(0.2f, 0.2f)
    );

    static <T extends Entity> EntityType<T> create(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Arcturus.id(name));
        return Registry.register(Registries.ENTITY_TYPE, key.getValue(), builder.build(String.valueOf(key)));
    }

    static void init() {
        // Entities are Registered Statically
    }

    static void clientInit() {
        EntityRendererRegistry.register(MISSILE_ENTITY, EmptyEntityRenderer::new);
    }
}
