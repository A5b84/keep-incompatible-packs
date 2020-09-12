package io.github.a5b84.keepincompatiblepacks.mixin;

import java.util.Iterator;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.options.GameOptions;

@Mixin(GameOptions.class)
public abstract class GameOptionsMixin {

    /** Empêche le jeu d'enlever les packs incompatibles quand le jeu démare
     * @see GameOptions#addResourcePackProfilesToManager */
    @Redirect(method = "addResourcePackProfilesToManager",
        at = @At(value = "INVOKE", target = "java/util/Iterator.remove()V", ordinal = 1))
    public void removeProxy(Iterator<String> it) {}

}
