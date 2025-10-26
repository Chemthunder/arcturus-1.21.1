package dev.chemthunder.arcturus.client;

import dev.chemthunder.arcturus.index.ArcturusEntities;
import net.fabricmc.api.ClientModInitializer;

public class ArcturursClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ArcturusEntities.clientInit();
    }
}
