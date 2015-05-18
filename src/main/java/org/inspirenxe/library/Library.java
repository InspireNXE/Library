package org.inspirenxe.library;

import com.google.inject.Inject;
import org.inspirenxe.library.commands.AddCommand;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ConstructionEvent;
import org.spongepowered.api.event.state.ServerAboutToStartEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

@Plugin(id = "library", name = "Library", version = "1.0")
public class Library {
    @Inject public Game game;
    @Inject public Logger logger;

    private static Library instance;

    private final CommandSpec libraryCommandSpec = CommandSpec.builder()
            .description(Texts.of("Adds the held book to the library. If another book with the same author and title are present in the library it will append '.#' to the end of the title in the library only."))
            .child(new AddCommand().getCommandSpec(), "add")
            .build();

    @Subscribe
    public void onConstruction(ConstructionEvent event) {
        instance = this;
    }

    @Subscribe
    public void onServerAboutToStart(ServerAboutToStartEvent event) {
        game.getCommandDispatcher().register(this, libraryCommandSpec, "library");
    }

    public static Library getInstance() {
        return instance;
    }
}
