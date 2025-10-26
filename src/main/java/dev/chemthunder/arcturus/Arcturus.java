package dev.chemthunder.arcturus;

import dev.chemthunder.arcturus.index.ArcturusEffects;
import dev.chemthunder.arcturus.index.ArcturusItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arcturus implements ModInitializer {
	public static final String MOD_ID = "arcturus";

    public static Identifier id (String path){
        return Identifier.of(MOD_ID, path); }
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ArcturusItems.initialize();
        ArcturusEntities.initialize();
        ArcturusEffects.initialize();

		LOGGER.info("debug init message");
	}
}