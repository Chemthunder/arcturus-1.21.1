package dev.chemthunder.arcturus.client;

import dev.chemthunder.arcturus.index.ArcturusEntities;
import net.fabricmc.api.ClientModInitializer;

public class ArcturusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ArcturusEntities.clientInit();
    }
}
