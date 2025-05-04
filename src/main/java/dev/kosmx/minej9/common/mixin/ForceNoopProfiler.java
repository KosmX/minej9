package dev.kosmx.minej9.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.util.profiling.jfr.FlightProfiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FlightProfiler.class)
public interface ForceNoopProfiler {

    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isPresent()Z"))
    private static boolean allowJfr(boolean original) {
        if (Runtime.version().optional().map(str -> str.toLowerCase().contains("openj9")).orElse(false)) {
            // Definitely OpenJ9 JVM
            return false;
        } else {
            // i have no idea
            return original;
        }
    }
}
