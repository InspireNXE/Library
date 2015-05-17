package org.inspirenxe.lore;

import com.google.inject.Inject;
import org.inspirenxe.lore.commands.AddCommand;
import org.slf4j.Logger;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

@Plugin(id = "library", name = "Library", version = "1.0")
public class Library {
    @Inject Logger logger;


    final CommandSpec libraryCommand = CommandSpec.builder()
            .description(Texts.of("Adds the held book to the library. If another book with the same author and title are present in the library it will append '.#' to the end of the title in the library only."))
            .child(AddCommand.ADD_COMMAND_SPEC, "add")
            .executor(new AddCommand())
            .build();
}
