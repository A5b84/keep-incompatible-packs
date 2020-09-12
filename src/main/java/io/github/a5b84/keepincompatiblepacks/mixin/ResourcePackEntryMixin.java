package io.github.a5b84.keepincompatiblepacks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.screen.pack.PackListWidget.ResourcePackEntry;
import net.minecraft.resource.ResourcePackCompatibility;

@Mixin(ResourcePackEntry.class)
public abstract class ResourcePackEntryMixin {

    /** Empêche l'écran de confirmation de s'ouvrir pour les packs incompatibles
     * @see ResourcePackEntry#mouseClicked */
    @Redirect(method = "mouseClicked", at = @At(value = "INVOKE", target = "net/minecraft/resource/ResourcePackCompatibility.isCompatible()Z"))
    private boolean isCompatibleProxy(ResourcePackCompatibility compatibility) {
        return true;
    }

}
