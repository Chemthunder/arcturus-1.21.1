package dev.chemthunder.arcturus.index;

import dev.chemthunder.arcturus.Arcturus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ArcturusEntities {

  //  EntityType<MissileEntity> MISSILE = create("missile", FabricEntityTypeBuilder.<MissileEntity>create(SpawnGroup.MISC, MissileEntity::new).disableSaving().dimensions(EntityDimensions.changing(0.2f, 0.2f)).build());



    static <T extends Entity> EntityType<T> create(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Arcturus.id(name));
        return Registry.register(Registries.ENTITY_TYPE, key.getValue(), builder.build(String.valueOf(key)));
    }

    static void init() {
        // Entities are Registered Statically
    }

    static void clientInit() {
        //
    }
}
