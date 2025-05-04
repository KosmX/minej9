package dev.kosmx.minej9.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.util.profiling.jfr.FlightProfiler;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FlightProfiler.class)
public interface ForceNoopProfiler {

    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isPresent()Z"))
    private static boolean allowJfr(boolean original) {
        if (original) {
            try {
                var a = WorldLoadFinishedEvent.TYPE; // this is going to fail if no JFR is present.
                return true;
            } catch (Throwable e) {
                return false;
            }
        } else return false;
    }
}
